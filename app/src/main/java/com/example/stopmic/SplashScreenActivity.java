package com.example.stopmic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        // Display the splash screen for a few seconds
        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, 3000); // 3 seconds
    }
}
