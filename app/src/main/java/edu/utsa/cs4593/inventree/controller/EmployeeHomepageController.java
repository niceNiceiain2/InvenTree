//package edu.utsa.cs4593.inventree.controller;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.View;
//import android.widget.Toast;
//
//import edu.utsa.cs4593.inventree.MainActivity;
//import edu.utsa.cs4593.inventree.ManagerHomepage;
//
//public class EmployeeHomepageController implements View.OnClickListener {
//
//    @Override
//    public void onClick(View view) {
//        Context context = view.getContext();
//        int duration = Toast.LENGTH_SHORT;
//        String username = MainActivity.username.getText().toString();
//        String password = MainActivity.password.getText().toString();
//
//        Intent intent = new Intent(context, ManagerHomepage.class);
//        intent.putExtra("username", username);
//        context.startActivity(intent);
//    }
//}
