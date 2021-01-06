package co.planetsystems.tela.gui;

import android.app.Activity;
import android.os.Bundle;

public class CustomPreferenceActivity extends Activity implements ListFragment.ItemSelectionListener {

    CustomPreferenceFragment mFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        mFragment = new CustomPreferenceFragment();
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, mFragment)
                .commit();
    }


    @Override
    public void onItemSelected(String subjectID, Bundle bundle) {
        if (mFragment == null) throw new NullPointerException("mFragment");
        mFragment.addItem(subjectID);
    }
}
