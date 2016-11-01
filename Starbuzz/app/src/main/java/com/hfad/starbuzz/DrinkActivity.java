package com.hfad.starbuzz;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        // Get required information that stored in intent
        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_DRINKNO);

        // Create a cursor
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ?",
                    new String[] {Integer.toString(drinkNo)},
                    null, null, null);

            // Move cursor to first record of data
            if(cursor.moveToFirst()) {
                // Get drink details from the cursor
                String nameText = cursor.getString(0);
                String descText = cursor.getString(1);
                Integer imageResId = cursor.getInt(2);
                boolean isFavourite = (cursor.getInt(3) == 1);

                // Populate the drink name
                TextView nameTextView = (TextView) findViewById(R.id.name);
                nameTextView.setText(nameText);

                // Populate the drink description
                TextView descTextView = (TextView) findViewById(R.id.description);
                descTextView.setText(descText);

                // Populate the drink image
                ImageView photoImageView = (ImageView) findViewById(R.id.photo);
                photoImageView.setImageResource(imageResId);
                photoImageView.setContentDescription(descText);

                // Populate the favourite checkbox
                CheckBox favouriteCheckBox = (CheckBox) findViewById(R.id.favourite);
                favouriteCheckBox.setChecked(isFavourite);
            }

            // Close the cursor & database
            cursor.close();
            db.close();
        } catch(SQLiteException ex) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onFavouriteClicked(View view) {
        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);

        CheckBox favouriteCheckBox = (CheckBox) view.findViewById(R.id.favourite);
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("FAVORITE", favouriteCheckBox.isChecked());

        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getWritableDatabase();
            db.update("DRINK", drinkValues, "_id = ?", new String[]{Integer.toString(drinkNo)});
            db.close();

        } catch(SQLException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
