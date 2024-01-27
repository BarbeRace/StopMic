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
            // Ecran off, mais bizarre ça tarde à arriver
            Log.d("ScreenLockReceiver", "Screen locked coucou");
            // Désactive le microphone
            context.stopService(new Intent(context, MicrophoneService.class));
        } else if (action.equals(Intent.ACTION_SCREEN_ON)) {
            // Ecran on
            Log.d("ScreenLockReceiver", "Screen unlocked coucou censé restart le service Microphone");
            // Réactive le microphone
            context.startService(new Intent(context, MicrophoneService.class));
        }
    }
}
