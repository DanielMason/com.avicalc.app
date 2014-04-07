package com.avicalc.app;

import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Checklists extends FragmentActivity {

    private FragmentManager supportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist_menu);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.checklistContainer, new ChecklistMenu())
                        .commit();
        }
        // Keeps screen on! Disabled at the moment.
        //      getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void load172menu(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment ces172 = new Checklist172R();
        transaction.add(R.id.checklistContainer, ces172);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void load172prestart(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment ces172prestart = new Checklist172R_PreStart();
        transaction.add(R.id.checklistContainer, ces172prestart);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void load172preflight(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment ces172preflight = new Checklist172R_PreFlight();
        transaction.add(R.id.checklistContainer, ces172preflight);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void load172enginestart(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment ces172enginestart = new Checklist172R_EngineStart();
        transaction.add(R.id.checklistContainer, ces172enginestart);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void load172runup(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment ces172runup = new Checklist172R_RunUp();
        transaction.add(R.id.checklistContainer, ces172runup);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void load172vspeeds(View view) {
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        Fragment ces172vspeeds = new Checklist172R_Vspeeds();
        transaction.add(R.id.checklistContainer, ces172vspeeds);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public class ChecklistMenu extends Fragment {

        public ChecklistMenu() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chklst_menu, container, false);

            return rootView;
        }
    }

    public  class Checklist172R extends Fragment {

        public Checklist172R() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chklst_172r, container, false);
            return rootView;
        }
    }
    public  class Checklist172R_PreStart extends Fragment {

        public Checklist172R_PreStart() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chklst_172r_prestart, container, false);
            return rootView;
        }
    }
    public  class Checklist172R_RunUp extends Fragment {

        public Checklist172R_RunUp() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chklst_172r_runup, container, false);
            return rootView;
        }
    }
    public  class Checklist172R_PreFlight extends Fragment {

        public Checklist172R_PreFlight() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chklst_172r_preflight, container, false);
            return rootView;
        }
    }
    public  class Checklist172R_EngineStart extends Fragment {

        public Checklist172R_EngineStart() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chklst_172r_enginestart, container, false);
            return rootView;
        }
    }
    public  class Checklist172R_Vspeeds extends Fragment {

        public Checklist172R_Vspeeds() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chklst_172r_vspeeds, container, false);
            return rootView;
        }
    }

}