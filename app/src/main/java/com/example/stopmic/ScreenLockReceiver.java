package com.example.stopmic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenLockReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            // Déverrouillage de l'écran
            Log.d("ScreenLockReceiver", "Screen locked");
            // Désactive le microphone
            context.stopService(new Intent(context, MicrophoneService.class));
        } else if (action.equals(Intent.ACTION_SCREEN_ON)) {
            // Verrouillage de l'écran
            Log.d("ScreenLockReceiver", "Screen unlocked");
            // Réactive le microphone
            context.startService(new Intent(context, MicrophoneService.class));
        }
    }
}
