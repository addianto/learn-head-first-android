package com.hfad.starbuzz;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set data in ListView
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<Drink>(this,
                android.R.layout.simple_list_item_1, Drink.drinks);
        ListView listView = getListView();
        listView.setAdapter(listAdapter);
    }
}
