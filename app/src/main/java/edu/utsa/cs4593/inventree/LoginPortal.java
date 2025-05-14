package edu.utsa.cs4593.inventree;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import edu.utsa.cs4593.inventree.controller.*;
import edu.utsa.cs4593.inventree.model.Inventory;
import edu.utsa.cs4593.inventree.model.UserDatabase;

public class LoginPortal {
    private Context context;

    public LoginPortal(Context context){
        this.context = context;
    }

    public void login(String username, String password){
        UserDatabase.loadUsers(context);

        if(UserDatabase.isValidUser(username,password)){
            UserDatabase.setCurrentUser(username);
            String role = UserDatabase.getRole(username);
            if (role.equalsIgnoreCase("employee")) {
                Intent intent = new Intent(context, EmployeeHomepage.class);
                if (Inventory.getInventory() == null) {
                    Inventory.buildInventory(context);
                }
                context.startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(context, ManagerHomepageController.class);
                if (Inventory.getInventory() == null) {
                    Inventory.buildInventory(context);
                }
                context.startActivity(intent);
            }
        }else{
            Toast.makeText(context, "Invalid login credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
