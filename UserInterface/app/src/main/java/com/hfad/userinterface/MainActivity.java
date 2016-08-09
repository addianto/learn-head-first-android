package com.hfad.userinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Using IDE feature to create Toast
        Toast.makeText(MainActivity.this, "This is a toast. Using Android Studio",
                Toast.LENGTH_SHORT).show();

        // Manually create Toast
        CharSequence text = "This is a toast. Manually created.";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
    }
}
