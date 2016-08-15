package com.hfad.workout;

public class Workout {

    private String name;
    private String description;

    public static final Workout[] workouts = {
            createWorkout("The Limb Loosener", "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            createWorkout("Core Agony", "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            createWorkout("The Wimp Special", "5 Pull-ups\n10 Push-ups\n15 Squats"),
            createWorkout("Strength and Length", "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    /**
     * Private constructor. Objects will be instantiated via factory method.
     * @param name
     * @param description
     */
    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Workout createWorkout(String name, String description) {
        return new Workout(name, description);
    }
}
