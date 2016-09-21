package com.hfad.bitsandpizzas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is
        // present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                // Intent to start new activity from this class to OrderActivity
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                // Code to run when the Create Order item is clicked
                return true;
            case R.id.action_settings:
                // Code to run when the settings item is clicked
                // Returning true tells Android you've dealt with the item being clicked
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
