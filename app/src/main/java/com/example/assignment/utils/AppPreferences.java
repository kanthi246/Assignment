package com.example.assignment.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {
    public static final String PREF_USER_SESSION = "USER_SESSION";
    public static final String PREF_ACCESS_TOKEN = "ACCESS_TOKEN";

    public static void setAccessToken(Context context, String token) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_USER_SESSION,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PREF_ACCESS_TOKEN, token);
        editor.apply();
    }

    public static String getAccessToken(Context context) {
        return context.getSharedPreferences(PREF_USER_SESSION, Context.MODE_PRIVATE).getString(PREF_ACCESS_TOKEN, null);
    }
}


