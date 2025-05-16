package edu.utsa.cs4593.inventree;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//import edu.utsa.cs4593.inventree.controller.*;
//import edu.utsa.cs4593.inventree.model.Inventory;
import edu.utsa.cs4593.inventree.controller.EmployeeHomepageController;
import edu.utsa.cs4593.inventree.model.UserDatabase;
import edu.utsa.cs4593.inventree.controller.ManagerHomepageController;

public class LoginPortal {
    private Context context;

    public LoginPortal(Context context) {
        this.context = context;
    }

    public void login(String username, String password) {
        UserDatabase.loadUsers(context);

        if (UserDatabase.isValidUser(username, password)) {
            UserDatabase.setCurrentUser(username);
            String role = UserDatabase.getRole(username);
            if (role.equalsIgnoreCase("Manager")) {
                Intent intent = new Intent(context, ManagerHomepageController.class);
                intent.putExtra("username", username);
                context.startActivity(intent);
            } else if (role.equalsIgnoreCase("Employee")) {
                Intent intent = new Intent(context, EmployeeHomepageController.class);
                intent.putExtra("username", username);
                context.startActivity(intent);
            }else {
                Toast.makeText(context, "Invalid login credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
