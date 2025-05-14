package edu.utsa.cs4593.inventree.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs4593.inventree.EmployeeHomepage;

public class EmployeeHomepageController implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        int duration = Toast.LENGTH_SHORT;

        Intent intent = new Intent(context, EmployeeHomepage.class);
        context.startActivity(intent);
    }
}
