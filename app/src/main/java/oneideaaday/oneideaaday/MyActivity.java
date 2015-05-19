package oneideaaday.oneideaaday;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

//import android.support.v4.app.FragmentActivity;
;


public class MyActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */


    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        //FragmentManager fragmentManager = getFragmentManager();
        Fragment objFragment = null;
        switch (position) {
            case 0:
                //Intent intent = new Intent(this,Fact_1.class);
                //startActivity(intent);
                objFragment = new Fact_1();
                break;
            case 1:
                //Intent intent2 = new Intent(this,Fact_2.class);
                //startActivity(intent2);
                objFragment = new Fact_2();
                break;
            case 2:
                //Intent intent3 = new Intent(this,Fact_3.class);
                //startActivity(intent3);
                objFragment = new Fact_3();
                break;
            case 3:
                //Intent intent4 = new Intent(this,Favoris.class);
                //startActivity(intent4);
                objFragment = new Profil();
                break;

            case 4:
                //android.app.FragmentManager fragmentManager = getFragmentManager();
                //Intent intent6 = new Intent(this,SettingsActivity.class);
                //startActivity(intent6);
                objFragment = new Settings();
                break;
            case 5:
                //Intent intent5 = new Intent(this,Profil.class);
                //startActivity(intent5);
                objFragment = new Favoris();
                break;

        }
        // update the main content by replacing fragments


        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, objFragment)
                .commit();

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section4);
                break;
            case 2:
                mTitle = getString(R.string.title_section5);
                break;
            case 3:
                mTitle = getString(R.string.title_section6);
                break;
            case 4:
                mTitle = getString(R.string.title_section1);
                break;
            case 5:
                mTitle = getString(R.string.title_section2);
                break;
            case 6:
                mTitle = getString(R.string.title_section3);
        }
    }

    public void restoreActionBar() throws java.lang.NullPointerException {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        mTitle = "OneIdeaADay";
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            //getMenuInflater().inflate(R.menu.my, menu); #action_example
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            return rootView;
        }

        public void onAttach(FragmentActivity activity) {
            super.onAttach(activity);
            ((MyActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public void showAlert (View view) {
        new AlertDialog.Builder(this).setTitle("Remettre à zéro").setMessage("Etes-vous bien sûr de vouloir tout remettre à zéro ?").setNeutralButton("Oui", null)
                .show();

    }

}
