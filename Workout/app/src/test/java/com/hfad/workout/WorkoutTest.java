package com.hfad.workout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkoutTest {

    private Workout[] workouts;

    @Before
    public void setUp() throws Exception {
        workouts = new Workout[] {
                Workout.createWorkout("A", "Desc A"),
                Workout.createWorkout("B", "Desc B"),
                Workout.createWorkout("C", "Desc C")
        };
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("A", workouts[0].getName());
    }

    @Test
    public void testGetDescription() throws Exception {
        assertEquals("Desc B", workouts[1].getDescription());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("C", workouts[2].toString());
    }

    @Test
    public void testCreateWorkout() throws Exception {
        Workout obj = Workout.createWorkout("Test", "Desc Test");
        assertNotNull(obj);
        assertTrue(obj instanceof Workout);
    }
}