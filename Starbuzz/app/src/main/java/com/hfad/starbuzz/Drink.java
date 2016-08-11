package com.hfad.starbuzz;

public class Drink {

    private String name;
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of espresso shots with steamed milk", 0),
                    // R.drawable.latte),
            new Drink("Cappucino", "Espresso, hot milk, and a steamed milk foam", 1),
                    // R.drawable.cappucinno),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh", 2),
                    // R.drawable.filter)
    };

    /**
     * Private constructor. The object(s) will be constructed using a factory
     * method.
     *
     * @param name
     * @param description
     * @param imageResourceId
     */
    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public static Drink createDrink(String name, String description, int imageResourceId) {
        return new Drink(name, description, imageResourceId);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                '}';
    }
}
