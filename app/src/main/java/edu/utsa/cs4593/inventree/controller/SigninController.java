package edu.utsa.cs4593.inventree.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs4593.inventree.MainActivity;
import edu.utsa.cs4593.inventree.EmployeeHomepage;
import edu.utsa.cs4593.inventree.ManagerHomepage;

public class SigninController implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        int duration = Toast.LENGTH_SHORT;
        String username = MainActivity.username.getText().toString();
        String password = MainActivity.password.getText().toString();

        if ( (username.equals("iain")) || (username.equals("isabella")) )
        {
            if (password.equals("password")) {
                Intent intent = new Intent(context, ManagerHomepage.class);
                intent.putExtra("username", username);
                context.startActivity(intent);
            }
            else {
                Toast toast = Toast.makeText(context, "Error wrong password " + username, duration);
                toast.show();
            }
        }
        else {
            Toast toast = Toast.makeText(context, "Error wrong username " + username, duration);
            toast.show();
        }
    }
}
