package com.hfad.workout;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        // Get a reference to the frame layout that contains WorkoutDetailFragment.
        // This will exist if the app is being run on a device with a large screen
        View fragmentContainer = findViewById(R.id.fragment_container);

        if(fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();

            details.setWorkoutId(id);
            tx.replace(R.id.fragment_container, details);
            tx.addToBackStack(null);

            // Cannot use FRAGMENT_FADE?
            tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

            tx.commit();
        } else {
            // If the frame layout isn't there, the app must be running on a device
            // with a smaller screen
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}
