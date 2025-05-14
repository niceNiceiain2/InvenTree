package edu.utsa.cs4593.inventree.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import edu.utsa.cs4593.inventree.SearchActivity;

public class SearchItemScreenController implements View.OnClickListener {
        private Context context;

        public SearchItemScreenController(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {

            // Redirect user to Search Activity
            Intent intent = new Intent(context, SearchActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        }
}