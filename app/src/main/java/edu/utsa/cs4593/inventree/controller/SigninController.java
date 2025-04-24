package edu.utsa.cs4593.inventree.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.utsa.cs4593.inventree.MainActivity;
import edu.utsa.cs4593.inventree.MainPageActivity;

public class SigninController implements View.OnClickListener {

    /*
     * Iain Summerlin - tea587
     *
     */
    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        int duration = Toast.LENGTH_SHORT;
        String username = MainActivity.username.getText().toString();
        String password = MainActivity.password.getText().toString();

        if (username.equals("iain")) {
            Toast toast = Toast.makeText(context,  username, duration);
            toast.show();

            Intent intent = new Intent(context, MainPageActivity.class);
            intent.putExtra("username", username);
            context.startActivity(intent);
        }
        else {
            Toast toast = Toast.makeText(context, "Error wrong user " + username, duration);
            toast.show();
        }
    }
}
