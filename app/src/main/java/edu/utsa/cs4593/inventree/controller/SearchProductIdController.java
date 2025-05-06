package edu.utsa.cs4593.inventree.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import edu.utsa.cs4593.inventree.ManagerHomepage;
import edu.utsa.cs4593.inventree.R;

public class SearchProductIdController extends AppCompatActivity {

    /*
     * on create will display the search product id xml layout also
     * known as the enter product id screen to manually enter the product id
     * for searching for a product
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_product_id);

        /*
         * creates an image button on click listener and sets intent
         * to log out the user and take them back to the login portal
         * when logout button is clicked
         */
        ImageButton logout = findViewById(R.id.logOutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductIdController.this, LoginActivityController.class);
                startActivity(intent);
            }
        });

        /*
         * creates an image button on click listener and sets intent
         * to take user back to the homepage when the home image logo is
         * clicked
         *
         * TODO: CHANGE THIS TO INCLUDE A CONDITIONAL DETERMINING IF THE
         *  USER SHOULD BE BROUGHT TO THE MANAGER HOMEPAGE OR THE EMPLOYEE
         *  HOMEPAGE
         */
        ImageButton homeImageLogoButton = findViewById(R.id.home_image_logo);
        homeImageLogoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductIdController.this, ManagerHomepage.class);
                startActivity(intent);
            }
        });

    }



}
