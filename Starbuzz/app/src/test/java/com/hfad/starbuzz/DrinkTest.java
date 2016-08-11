package com.hfad.starbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {

    private Drink[] drinks;

    @Before
    public void setUp() throws Exception {
        drinks = new Drink[]{
                Drink.createDrink("Drink A", "Description A", 0),
                Drink.createDrink("Drink B", "Description B", 1),
                Drink.createDrink("Drink C", "Description C", 2)
        };
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Drink A", drinks[0].getName());
    }

    @Test
    public void testGetDescription() throws Exception {
        assertEquals("Description B", drinks[1].getDescription());
    }

    @Test
    public void testGetImageResourceId() throws Exception {
        assertEquals(2, drinks[2].getImageResourceId());
    }

    @Test
    public void testCreateDrink() throws Exception {
        Drink obj = Drink.createDrink("Obj", "Description Obj", 0);

        assertNotNull(obj);
        assertTrue(obj instanceof Drink);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Drink{name='Drink A'}", drinks[0].toString());
    }
}