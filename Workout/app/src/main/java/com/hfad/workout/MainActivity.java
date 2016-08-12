package com.hfad.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the fragment to be included into activity
        // Had to use supportFragmentManager instead of the usual fragmentManager
        // Consequently, the Activity class had to extends AppCompatActivity instead of Activity
        WorkoutDetailFragment fragment = (WorkoutDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        fragment.setWorkoutId(1);
    }
}
