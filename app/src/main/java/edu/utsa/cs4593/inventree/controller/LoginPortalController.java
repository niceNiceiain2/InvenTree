package edu.utsa.cs4593.inventree.controller;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import edu.utsa.cs4593.inventree.EmployeeHomepage;
import edu.utsa.cs4593.inventree.ManagerHomepage;
import edu.utsa.cs4593.inventree.model.UserDatabase;

public class LoginPortalController {
    private Context context;

    public LoginPortalController(Context context){
        this.context = context;
    }

    public void login(String username, String password){
        UserDatabase.loadUsers(context);

        if(UserDatabase.isValidUser(username,password)){
            String role = UserDatabase.getRole(username);
            if (role.equalsIgnoreCase("employee")) {
                context.startActivity(new Intent(context, EmployeeHomepage.class));
            }else{
                context.startActivity(new Intent(context, ManagerHomepage.class));
            }
        }else{
            Toast.makeText(context, "Invalid login credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
