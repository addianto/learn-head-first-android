package com.hfad.starbuzz;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class TopLevelActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private Cursor favouritesCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        // Set click event listener on ListView
        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        });

        // Populate the favourites list
        ListView listFavourites = (ListView) findViewById(R.id.list_favourites);
        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();
            favouritesCursor = db.query("DRINK", new String[] {"_id", "NAME"},
                    "FAVOURITE = 1", null, null, null, null);

            CursorAdapter favouriteAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1, favouritesCursor,
                    new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            listFavourites.setAdapter(favouriteAdapter);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        // Navigate to DrinkActivity if a drink is clicked
        listFavourites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TopLevelActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKNO, (int) id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        favouritesCursor.close();
        db.close();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            db = starbuzzDatabaseHelper.getReadableDatabase();

            Cursor cursor = db.query("DRINK", new String[] {"_id", "NAME"},
                    "FAVORITE = 1", null, null, null, null);
            ListView listFavourites = (ListView) findViewById(R.id.list_favourites);
            CursorAdapter adapter = (CursorAdapter) listFavourites.getAdapter();
            adapter.changeCursor(cursor);
            favouritesCursor = cursor;
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
