package com.example.quizapplication.utilities;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.quizapplication.R;

public class AppUtilities {

    private static long backPassed = 0;

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void tapPromptToExit(Activity activity) {
        if (backPassed + 2500 > System.currentTimeMillis()) {
            showToast(activity.getApplicationContext(), activity.getResources().getString(R.string.tap_again));
        }
        backPassed = System.currentTimeMillis();
    }
}
