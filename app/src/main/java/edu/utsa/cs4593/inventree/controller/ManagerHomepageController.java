package edu.utsa.cs4593.inventree.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import edu.utsa.cs4593.inventree.R;
import edu.utsa.cs4593.inventree.model.User;
import edu.utsa.cs4593.inventree.model.UserDatabase;


public class ManagerHomepageController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
         * sets the manager homepage layout and the features
         * that are available to use for a User with a role Manager
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_homepage);

        TextView userGuideTextView = findViewById(R.id.homepageGuide);
        String homepageGuideText = loadTextFromAssets("inventree_homepage_guide.txt");
        userGuideTextView.setText(homepageGuideText);

        ImageButton logout = findViewById(R.id.logOutButton);
        logout.setOnClickListener(new LogoutController(getApplicationContext()));

        String username = UserDatabase.getCurrentUser();
        User currentUser = UserDatabase.findUser(username);
        TextView un = findViewById(R.id.managerName);
        un.setTextSize(20);
        String name = currentUser.getFirstName() + " " + currentUser.getLastName();
        un.setText(name);

        ImageButton searchProduct = findViewById(R.id.search_button);
        searchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagerHomepageController.this, SearchProductController.class);
                startActivity(intent);
            }
        });

        /*
         * TODO: ADD IMAGEBUTTON ON CLICK LISTENERS AND INTENTS TO START NEW ACTIVITY FOR
         *  - PROCESS DAMAGES ACTIVITY
         *  - EDIT PRODUCT DETAILS ACTIVITY
         *  - ADD TO INVENTORY ACTIVITY
         */
    }

    private String loadTextFromAssets(String filename){
        StringBuilder text = new StringBuilder();
        try {
            InputStream is = getAssets().open(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine())!=null){
                text.append(line).append("\n");
            }
            reader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return text.toString();
    }
}
