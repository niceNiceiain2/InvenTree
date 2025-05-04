package edu.utsa.cs4593.inventree.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import edu.utsa.cs4593.inventree.MainActivity;
import edu.utsa.cs4593.inventree.EmployeeHomepage;
import edu.utsa.cs4593.inventree.ManagerHomepage;
import edu.utsa.cs4593.inventree.model.Inventory;
import edu.utsa.cs4593.inventree.model.User;
import edu.utsa.cs4593.inventree.model.UserDatabase;

public class UserAuthentication{

    private Context context;
    private String username;
    private String password;

    public UserAuthentication(Context context, String username, String password){
        this.context = context;
        this.username = username;
        this.password = password;
    }

    public void authenticate(){
        if(UserDatabase.isValidUser(username,password)){
            if(Inventory.getInventory() == null){
                Inventory.buildInventory(context);
            }

            String role = UserDatabase.getRole(username);

            Intent intent;
            if("Manager".equalsIgnoreCase(role)){
                intent = new Intent(context, ManagerHomepage.class);
            }else{
                intent = new Intent(context, EmployeeHomepage.class);
            }

            intent.putExtra("username", username);
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Error: wrong username or password", Toast.LENGTH_SHORT).show();
        }
    }
}

//public class UserAuthentication implements View.OnClickListener {
//
//    @Override
//    public void onClick(View view) {
//        Context context = view.getContext();
//        int duration = Toast.LENGTH_SHORT;
//        String username = MainActivity.username.getText().toString();
//        String password = MainActivity.password.getText().toString();

//        if ( (username.equals("iainMGR")) || (username.equals("isabellaMGR")) )
//        {
//            if (password.equals("password")) {
//                if (Inventory.getInventory() == null) {
//                    Inventory.buildInventory(context);
//                }
//                Intent intent = new Intent(context, ManagerHomepage.class);
//                intent.putExtra("username", username);
//                context.startActivity(intent);
//            }
//            else {
//                Toast toast = Toast.makeText(context, "Error wrong password " + username, duration);
//                toast.show();
//            }
//        }
//        else if ( (username.equals("iain")) || (username.equals("isabella")) )
//        {
//            if (password.equals("password")) {
//                if (Inventory.getInventory() == null) {
//                    Inventory.buildInventory(context);
//                }
//                Intent intent = new Intent(context, EmployeeHomepage.class);
//                intent.putExtra("username", username);
//                context.startActivity(intent);
//            }
//        }
//        else {
//            Toast toast = Toast.makeText(context, "Error wrong username " + username, duration);
//            toast.show();
//        }
//
//        Log.d("LOGIN_ATTEMPT", "Username entered: " + username);
//        Log.d("LOGIN_ATTEMPT", "Password entered: " + password);
//        User matchedUser = UserDatabase.findUser(username, password);
//
//        if(matchedUser != null){
//            Log.d("LOGIN_SUCCESS", "Matched user: " + matchedUser.getFirstName() + " " + matchedUser.getLastName());
//            if(Inventory.getInventory() == null){
//                Inventory.buildInventory(context);
//            }
//
//            if(matchedUser.getRole().equalsIgnoreCase("Manager")) {
//                Intent intent = new Intent(context, ManagerHomepage.class);
//                intent.putExtra("username", username);
//                context.startActivity(intent);
//            }else{
//                Intent intent = new Intent(context, EmployeeHomepage.class);
//                intent.putExtra("username", username);
//                context.startActivity(intent);
//            }
//        }else {
//            Log.d("LOGIN_FAILED", "No match found for username: " + username);
//            Toast toast = Toast.makeText(context, "Incorrect username or password", duration);
//            toast.show();
//        }
//    }
//}
