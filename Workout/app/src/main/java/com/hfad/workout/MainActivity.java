package com.hfad.workout;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        WorkoutDetailFragment details = new WorkoutDetailFragment();
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();

        details.setWorkoutId(id);
        tx.replace(R.id.fragment_container, details);
        tx.addToBackStack(null);

        // Cannot use FRAGMENT_FADE?
        tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        tx.commit();
    }
}
