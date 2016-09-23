package com.hfad.joke;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class DelayedMessageService extends IntentService {

    private static final long TEN_SECONDS = 10000;

    public static final String EXTRA_MESSAGE = "message";

    private Handler handler;

    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this) {
            try {
                wait(TEN_SECONDS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler = new Handler();
        return super.onStartCommand(intent, flags, startId);
    }

    private void showText(final String text) {
        Log.v("DelayedMessageService", "The message is " + text);
        handler.post(new Runnable() {

            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
            }
        });
    }
}
