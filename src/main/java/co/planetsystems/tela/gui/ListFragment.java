package co.planetsystems.tela.gui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

import co.planetsystems.tela.R;

public class ListFragment extends DialogFragment {

	// ===========================================================
	// Public types
	// ===========================================================

	public interface ItemSelectionListener {
		void onItemSelected(String subjectID, Bundle bundle);
	}

	// ===========================================================
	// Private static fields
	// ===========================================================

	private static final String EXTRA_ENABLED = "enabled";
	private static final String TAG = "ListFragment";

	private static List<String> mDefaultItems;

	// ===========================================================
	// Public static methods
	// ===========================================================

	public static DialogFragment newInstance(List<String> defaultItems, boolean enabled, Bundle bundle) {
		mDefaultItems = defaultItems;
		ListFragment fragment = new ListFragment();
		fragment.setArguments(bundle);
		return fragment;
	}

	// ===========================================================
	// Private fields
	// ===========================================================

	private ListView mListView;
	private ItemSelectionListener mListener;
	private List<String> mItems;

	// ===========================================================
	// Private constructor
	// ===========================================================

	public ListFragment() {
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
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setCancelable(true);
		setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Light);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (ItemSelectionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() + " must implement SelectionListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.subject_list_fragment, null);
		mItems = new ArrayList<>();
		for (String item : mDefaultItems) {
			mItems.add(item);
		}
		if (mItems.isEmpty()) {
			mItems.add(getResources().getString(R.string.msg_no_records_in_database));
		}
		mListView = (ListView) view.findViewById(R.id.list);
		mListView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mItems));
		mListView.setEnabled(true);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				for (String item : mDefaultItems) {
					if (item.equals(mItems.get(position))) {
						mListener.onItemSelected(item, getArguments());
						break;
					}
				}
				dismiss();
			}
		});

		builder.setView(view);
		builder.setTitle(R.string.msg_database);
		return builder.create();
	}
}
