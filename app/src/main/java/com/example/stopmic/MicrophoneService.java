package com.example.stopmic;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

import java.util.Objects;

public class MicrophoneService extends Service {
    private static final String TAG = "MicrophoneService";
    private AudioManager audioManager;

    @Override
    public void onCreate() {
        super.onCreate();
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Received start command");
        if (intent != null && Objects.equals(intent.getAction(), Intent.ACTION_SCREEN_ON)) {
            // Activate the microphone
            audioManager.setMicrophoneMute(false);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "Received bind request");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MicrophoneService destroyed");
        // Désactive le microphone
        audioManager.setMicrophoneMute(true);
    }
}