package com.hfad.messenger;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        // Explicit intent
        // Intent intent = new Intent(this, ReceiveMessageActivity.class);
        // intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);

        // Implicit intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, messageText);

        // Chooser dialog
        Intent chosenIntent = Intent.createChooser(intent, getString(R.string.chooser));

        try {
            startActivity(chosenIntent);
        } catch (ActivityNotFoundException ex) {
            chosenIntent = new Intent(this, ReceiveMessageActivity.class);
            chosenIntent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
            startActivity(chosenIntent);
        }
    }
}
