package com.hfad.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        } else {
            FragmentTransaction tx = getChildFragmentManager().beginTransaction();
            StopwatchFragment fragment = new StopwatchFragment();

            tx.replace(R.id.stopwatch_container, fragment);
            tx.addToBackStack(null);

            // Cannot use TRANSIT_FRAGMENT_FADE?
            tx.setTransition(FragmentTransaction.TRANSIT_NONE);
            tx.commit();
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("workoutId", workoutId);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView(); // Get the fragment's root view, i.e. the activity

        if(view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());

            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}
