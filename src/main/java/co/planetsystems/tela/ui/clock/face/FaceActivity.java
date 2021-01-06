package co.planetsystems.tela.ui.clock.face;

import com.neurotec.face.verification.client.NCapturePreviewEvent;
import com.neurotec.face.verification.client.NCapturePreviewListener;
import com.neurotec.face.verification.client.NFaceVerificationClient;
import com.neurotec.face.verification.client.NOperationResult;
import com.neurotec.face.verification.client.NStatus;
import com.neurotec.face.verification.server.rest.ApiClient;
import com.neurotec.face.verification.server.rest.ApiException;
import com.neurotec.face.verification.server.rest.api.OperationApi;

import co.planetsystems.tela.NFV;
import co.planetsystems.tela.R;
import co.planetsystems.tela.data.teacher.Teacher;
import co.planetsystems.tela.databinding.ActivityFaceBinding;
import co.planetsystems.tela.gui.NFaceVerificationClientView;
import co.planetsystems.tela.gui.SettingsActivity;
import co.planetsystems.tela.gui.SettingsFragment;
import co.planetsystems.tela.utils.BaseActivity;
import co.planetsystems.tela.utils.FVDatabaseHelper;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FaceActivity extends BaseActivity {
	public static final String ACTION = "co.planetsystems.tela.ui.clock.face.ACTION";
	public static final String ACTION_CLOCK_IN = "co.planetsystems.tela.ui.clock.face.ACTION_CLOCK_IN";
	public static final String ACTION_CLOCK_OUT = "co.planetsystems.tela.ui.clock.face.ACTION_CLOCK_OUT";
	public static final String ACTION_ENROLL = "co.planetsystems.tela.ui.clock.face.ACTION_ENROLL";

	private static final String TAG = "FaceVerificationApp";
	private static final String EXTRA_REQUEST_CODE = "request_code";
	private static final int VERIFICATION_REQUEST_CODE = 1;
	private static final int REQUEST_CAMERA_PERMISSION = 10;
	private boolean mAppClosing;
	private NFaceVerificationClientView mFaceView;
	private OperationApi mOperationApi;
	private byte[] mTemplateBuffer = null;
	private FVDatabaseHelper mDBHelper;
	private NFaceVerificationClient mNFV = null;
	private Map<String, Integer> mPermissions = new HashMap<String, Integer>();

	private Button mEnrollButton = null;
	private Button mForceButton = null;
	private Button mCancelButton = null;
	private Button mVerifyButton = null;
	private Button mCheckLivenessButton = null;

	private ActivityFaceBinding binding;
	private FaceActivityViewModel viewModel;
	private List<Teacher> teacherList;

	private FaceActivityArgs faceActivityArgs;
	private Teacher teacher;
	private List<Teacher> teachers;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		binding = DataBindingUtil.setContentView(this, R.layout.activity_face);
		viewModel = new ViewModelProvider(this).get(FaceActivityViewModel.class);
		faceActivityArgs = FaceActivityArgs.fromBundle(getArguments());
		teacher = viewModel.getTeacherByNationalId(faceActivityArgs.getNationalId());
		teachers = viewModel.getTeachers();



		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		NFaceVerificationClient.setEnableLogging(true);
		// on application start you must set NCore context
		NFaceVerificationClient.setContext(this);
		mDBHelper = new FVDatabaseHelper(this);


		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if(mOperationApi != null) {
					binding.progressBar.setVisibility(View.GONE);
					createTemplate("Simon Peter");
				}
			}
		}, 2000);

		mFaceView = binding.nFaceView;

		String[] neededPermissions = getNotGrantedPermissions();
		if(neededPermissions.length == 0) {
			new InitializationTask().execute();
		} else {
			requestPermissions(neededPermissions);
		}
	}

	private Bundle getArguments() {
		return getIntent().getExtras();
	}

	private String[] getNotGrantedPermissions() {
		List<String> neededPermissions = new ArrayList<String>();
		int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

		if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
			neededPermissions.add(Manifest.permission.CAMERA);
		}
		return neededPermissions.toArray(new String[neededPermissions.size()]);
	}

	private void requestPermissions(String[] permissions) {
		ActivityCompat.requestPermissions(this, permissions,REQUEST_CAMERA_PERMISSION);
	}

	public void onRequestPermissionsResult(int requestCode, final String permissions[], int[] grantResults) {
		switch (requestCode) {
			case REQUEST_CAMERA_PERMISSION: {
				// Initialize the map with permissions
				mPermissions.clear();
				// Fill with actual results from user
				if (grantResults.length > 0) {
					for (int i = 0; i < permissions.length; i++) {
						mPermissions.put(permissions[i], grantResults[i]);
					}
					// Check if at least one is not granted
					if (mPermissions.get(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
						showError("Permission not granted", true);
					} else {
						Log.i(TAG, "Permission granted");
						new InitializationTask().execute();
					}
				}
			} break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nlvdemo, menu);
		return true;
	}

	@Override
	public void onResume() {
		super.onResume();
		mAppClosing = false;
		try {
			if ((mOperationApi == null) || (SettingsFragment.isUpdateClientNeeded())) {
				Log.i("TEST", "Update client");
				ApiClient client = new ApiClient();
				client.setConnectTimeout(60000);
				SettingsFragment.updateClientAuthentification(client);
				mOperationApi = new OperationApi(client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		mAppClosing = true;
	}

	public void createTemplate(final String id) {
		Log.i("TEST", "createTemplate");
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// cancel in there are any other operations in progress
					NFV.getInstance().cancel();
					byte[] registrationKey = NFV.getInstance().startCreateTemplate();
					byte[] serverKey = mOperationApi.validate(registrationKey);
					NOperationResult result = NFV.getInstance().finishOperation(serverKey);
					if (!mAppClosing) {
						mFaceView.setEventInfo(result);
						if (result.getStatus() == NStatus.SUCCESS) {
							mTemplateBuffer = result.getTemplate();
							if(faceActivityArgs.getAction().equals(ACTION_ENROLL)) {
								teacher.setFaceTemplate(mTemplateBuffer);
								viewModel.updateTeacher(teacher);
								finish();
							} else if (faceActivityArgs.getAction().equals(ACTION_CLOCK_IN)) {
								if(teachers != null) {
									for (Teacher teacher: teachers) {
										teacher.getFaceTemplate();
										NOperationResult face_result = NFV.getInstance().verify(teacher.getFaceTemplate(), mTemplateBuffer);
										if(face_result.getStatus() == NStatus.SUCCESS){
											Toast.makeText(FaceActivity.this, "Success Face " + teacher.getFirstName(), Toast.LENGTH_SHORT).show();
										}
									}
								}
							}
						} else {
							showInfo(String.format(getString(R.string.msg_operation_status), result.getStatus().toString().toLowerCase()));
						}
					}
				} catch (ApiException e) {
					showError(e);
				} catch (Exception e) {
					showError(e);
				}
			}
		}).start();
	}


	;

	public void checkLiveness() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// cancel in there are any other operations in progress
					NFV.getInstance().cancel();
					byte[] registrationKey = NFV.getInstance().startCheckLiveness();
					byte[] serverKey = mOperationApi.validate(registrationKey);
					NOperationResult result = NFV.getInstance().finishOperation(serverKey);
					if (!mAppClosing) {
						showInfo(String.format(getString(R.string.msg_operation_status), result.getStatus().toString().toLowerCase()));
						if (result.getStatus() == NStatus.SUCCESS) {
							mFaceView.setEventInfo(result);
						}
					}
				} catch (ApiException e) {
					showError(e);
				} catch (Throwable e) {
					showError(e);
				}
			}
		}).start();
	};

	// verify user
	public void verify(final byte[] template) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// cancel in there are any other operations in progress
					NFV.getInstance().cancel();
					if (template == null) {
						if (!mAppClosing) showInfo(getString(R.string.msg_buffer_is_null));
						return;
					}


					NOperationResult result = NFV.getInstance().verify(template);
					if (!mAppClosing) {
						mFaceView.setEventInfo(result);
						if (result.getStatus() == NStatus.SUCCESS) {
							showInfo(String.format(getString(R.string.msg_operation_status), String.format(getString(R.string.msg_verification_succeeded))));
						} else {
							showInfo(String.format(getString(R.string.msg_operation_status), String.format(getString(R.string.msg_verification_failed) + result.getStatus().toString().toLowerCase())));
						}
					}
				} catch (Throwable e) {
					showError(e);
				}
			}
		}).start();
	};


	@Override
	protected void onStop() {
		mAppClosing = true;
		try {
			NFV.getInstance().cancel();
		} catch (SecurityException e) {
			Log.e(TAG, e.getMessage(), e);
		}
		super.onStop();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i(TAG, "onOptionsItemSelected" + item.getTitle());
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.action_clear_db) {
			Log.i(TAG, "action_clear_db");
			mDBHelper.clearTable();
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("StaticFieldLeak")
	final class InitializationTask extends AsyncTask<Object, Boolean, Boolean> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			showProgress(R.string.msg_initialising);
		}

		@Override
		protected Boolean doInBackground(Object... params) {
			try {
				// get NFV for the first time
				mNFV = NFV.getInstance();

				// load settings
				SettingsFragment.loadSettings();

				mNFV.setCapturePreviewListener(new NCapturePreviewListener() {

					@Override
					public void capturePreview(NCapturePreviewEvent nCapturePreviewEvent) {

						mFaceView.setEvent(nCapturePreviewEvent);
					}
				});
			} catch (Exception e) {
				Log.e(TAG, e.getMessage(), e);
				return false;
			}
			return true;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			super.onPostExecute(result);
			hideProgress();
		}
	}
}
