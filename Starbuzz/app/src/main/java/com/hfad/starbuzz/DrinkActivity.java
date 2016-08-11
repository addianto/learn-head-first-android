package com.hfad.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        // Get required information that stored in intent
        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO);

        // Get the drink object
        Drink drink = Drink.drinks[drinkNo];

        // Update views
        ImageView photoImageView = (ImageView) findViewById(R.id.photo);
        photoImageView.setImageResource(drink.getImageResourceId());
        photoImageView.setContentDescription(drink.getName());

        TextView nameTextView = (TextView) findViewById(R.id.name);
        nameTextView.setText(drink.getName());

        TextView descTextView = (TextView) findViewById(R.id.description);
        descTextView.setText(drink.getDescription());
    }
}
