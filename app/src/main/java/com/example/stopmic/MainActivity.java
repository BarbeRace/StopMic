package com.example.stopmic;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Caca lancement main activity");
        ScreenLockReceiver rcv = new ScreenLockReceiver();
        MicrophoneService micService = new MicrophoneService();
        Intent micServiceIntent = new Intent(this, MicrophoneService.class);
        startService(micServiceIntent);

        ImageButton depardieuButton = findViewById(R.id.imageButton1);
        depardieuButton.setOnClickListener(v -> {
            Log.d(TAG, "coucou bouton depardieu Click !!!");
        });

        ImageButton borneButton = findViewById(R.id.imageButton2);
        borneButton.setOnClickListener(v -> {
            Log.d(TAG, "coucou bouton borne Click !!!");
        });
    }
}