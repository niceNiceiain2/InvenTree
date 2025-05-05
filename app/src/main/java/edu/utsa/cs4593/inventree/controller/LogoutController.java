package edu.utsa.cs4593.inventree.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import edu.utsa.cs4593.inventree.*;

public class LogoutController implements View.OnClickListener {

    private Context context;

    public LogoutController(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        // Clear stored user data (example using SharedPreferences)
        SharedPreferences preferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        // Redirect user to LoginActivity
        Intent intent = new Intent(context, LoginPortal.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}