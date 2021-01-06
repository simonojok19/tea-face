package co.planetsystems.tela.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import co.planetsystems.tela.R;

public class EnrollmentDialogFragment extends DialogFragment {

	// ===========================================================
	// Public types
	// ===========================================================

	public interface EnrollmentDialogListener {
		void onEnrollmentIDProvided(String id);
	}

	// ===========================================================
	// Private fields
	// ===========================================================

	private EnrollmentDialogListener mListener;
	private EditText mEditText;

	// ===========================================================
	// Public constructor
	// ===========================================================

	public EnrollmentDialogFragment() {
	}

	// ===========================================================
	// Public methods
	// ===========================================================

	public void show(FragmentManager manager, String tag) {
		FragmentTransaction ft = manager.beginTransaction();
		ft.add(this, tag);
		ft.commitAllowingStateLoss();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.fragment_enrollment, null);
		mEditText = (EditText) view.findViewById(R.id.enrollment_id);
		mEditText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
					InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
					in.hideSoftInputFromWindow(mEditText.getApplicationWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
					return !mEditText.getText().toString().equals("");
				}
				return false;
			}
		});

		builder.setView(view);
		builder.setTitle(R.string.msg_enrollment_enter_id);
		builder.setPositiveButton(getString(R.string.msg_enroll), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				mListener.onEnrollmentIDProvided(mEditText.getText().toString().trim());
			}
		});
		builder.setNegativeButton(getString(R.string.msg_cancel), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		});
		return builder.create();
	}
}
