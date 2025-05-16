package edu.utsa.cs4593.inventree.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.utsa.cs4593.inventree.R;
import edu.utsa.cs4593.inventree.model.User;
import edu.utsa.cs4593.inventree.model.UserDatabase;

public class EmployeeHomepageController extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        /*
         * sets the employee homepage layout and the features
         * that are available to use for a User with the role Employee
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employeehomepage);

        TextView userGuideTextView = findViewById(R.id.homepageGuide);
        String homepageGuideText = loadTextFromAssets("inventree_homepage_guide_employeeVer.txt");
        userGuideTextView.setText(homepageGuideText);

        ImageButton logout = findViewById(R.id.logOutButton);
        logout.setOnClickListener(new LogoutController(getApplicationContext()));

        String username = UserDatabase.getCurrentUser();
        if (username == null) {
            Toast.makeText(this, "Error: No user is currently logged in", Toast.LENGTH_LONG).show();
            finish(); // Or redirect to login screen
            return;
        }
        User currentUser = UserDatabase.findUser(username);
        if (currentUser == null) {
            Toast.makeText(this, "Error: User not found in database", Toast.LENGTH_LONG).show();
            finish(); // Or redirect to login screen
            return;
        }
        TextView un = findViewById(R.id.employeeName);
        un.setTextSize(20);


        String name = currentUser.getFirstName() + " " + currentUser.getLastName();
        un.setText(name);

        ImageButton searchProduct = findViewById(R.id.search_button);
        searchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(EmployeeHomepageController.this, SearchProductController.class);
                startActivity(intent);
            }
        });
    }

    private String loadTextFromAssets(String filename){
        StringBuilder text = new StringBuilder();
        try{
            InputStream is = getAssets().open(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine()) != null){
                text.append(line).append("\n");
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return text.toString();
    }

}
