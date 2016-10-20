package com.hfad.starbuzz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[] {Integer.toString(drinkNo)},
                    null, null, null);

            // Move cursor to first record of data
            if(cursor.moveToFirst()) {
                // Get drink details from the cursor
                String nameText = cursor.getString(0);
                String descText = cursor.getString(1);
                Integer imageResId = cursor.getInt(2);

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
            }

            // Close the cursor & database
            cursor.close();
            db.close();
        } catch(SQLiteException ex) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
