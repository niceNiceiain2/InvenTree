package edu.utsa.cs4593.inventree;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import edu.utsa.cs4593.inventree.controller.ManagerHomepageController;
import edu.utsa.cs4593.inventree.model.UserDatabase;

public class LoginPortal {
    private Context context;

    public LoginPortal(Context context){
        this.context = context;
    }

    public void login(String username, String password){
        UserDatabase.loadUsers(context);

        if(UserDatabase.isValidUser(username,password)){
            String role = UserDatabase.getRole(username);
            if (role.equalsIgnoreCase("employee")) {
//              context.startActivity(new Intent(context, EmployeeHomepage.class));
                Log.d("alternate route", "take to employee page");
            }
            else
            {
                Intent intent = new Intent(context, ManagerHomepageController.class);
                intent.putExtra("username", username);
                context.startActivity(intent);
            }
        }else{
            Toast.makeText(context, "Invalid login credentials", Toast.LENGTH_SHORT).show();
        }
    }
}
