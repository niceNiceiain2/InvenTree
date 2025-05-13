package edu.utsa.cs4593.inventree.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//import edu.utsa.cs4593.inventree.EmployeeHomepage;
import edu.utsa.cs4593.inventree.ManagerHomepage;
import edu.utsa.cs4593.inventree.model.Inventory;
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
//            if(Inventory.getInventory() == null){
//                Inventory.buildInventory(context);
//            }

            String role = UserDatabase.getRole(username);

            Intent intent;
            if("Manager".equalsIgnoreCase(role)){
                intent = new Intent(context, ManagerHomepage.class);
            }else{
//              intent = new Intent(context, EmployeeHomepage.class);
                Log.d("alternate route", "role is employee");
            }
              //may not need this intent since i want to change it to get user firstname
//            intent.putExtra("username", username);
//            context.startActivity(intent);
        } else {
            Toast.makeText(context, "Error: wrong username or password", Toast.LENGTH_SHORT).show();
        }
    }
}


