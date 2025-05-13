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

import edu.utsa.cs4593.inventree.ManagerHomepage;
import edu.utsa.cs4593.inventree.R;
import edu.utsa.cs4593.inventree.model.UserDatabase;

public class SearchProductController extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        /*
         * on create will display the layout of the search product xml
         * which includes the options of tap to scan, enter product id,
         * filter search, or for customer search
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_product);

        /*
         * will set the textview in the scrollview to a user guide
         * document that displays a reference to what each search feature
         * does and when to use it
         */
        TextView productSearchGuideTV = findViewById(R.id.product_search_guide);
        String productSearchGuideText = loadTextFromAssets("inventree_product_search_guide.txt");
        productSearchGuideTV.setText(productSearchGuideText);

        /*
         * creates an image button on click listener and sets intent
         * to log out the user and take them back to the login portal
         * when logout button is clicked
         */
        ImageButton logout = findViewById(R.id.logOutButton);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, LoginActivityController.class);
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

        String username = getIntent().getStringExtra("username");
        String userRole = UserDatabase.getRole(username);

        if ("Manager".equalsIgnoreCase(userRole)) {
            Intent intent = new Intent(this, ManagerHomepageController.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, ManagerHomepageController.class);
            startActivity(intent);
        }

        ImageButton homeImageLogoButton = findViewById(R.id.home_image_logo);
        homeImageLogoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, ManagerHomepage.class);
                startActivity(intent);
            }
        });

        /*
         * the following two textView and imageButton objects created set on
         * click listeners and start new activity, so when user clicks on
         * tap to scan text and/or button they are taken to the tap to scan page
         */
        TextView tapToScanButton1 = findViewById(R.id.tap_to_scan_text);
        tapToScanButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, ScanProductIdController.class);
                startActivity(intent);
            }
        });

        ImageButton tapToScanButton2 = findViewById(R.id.tap_to_scan_icon_button);
        tapToScanButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, ScanProductIdController.class);
                startActivity(intent);
            }
        });

        /*
         * the following two textView and ImageButton objects created set on
         * click listeners and start new activity, so when user clicks on
         * enter product id text and/or button they are taken to the enter product id page
         */
        TextView enterProductIdButton1 = findViewById(R.id.enter_product_id_text);
        enterProductIdButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, SearchProductIdController.class);
                startActivity(intent);
            }
        });

        ImageButton enterProductIdButton2 = findViewById(R.id.enter_product_id_icon_button);
        enterProductIdButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, SearchProductIdController.class);
                startActivity(intent);
            }
        });

        /*
         * the following two textView and ImageButton objects created set on
         * click listeners and start new activity, so when user clicks on
         * filter search text and/or button they are taken to the for customer search page
         */
        TextView filterSearchButton1 = findViewById(R.id.filter_search_text);
        filterSearchButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, FilterSearchController.class);
                startActivity(intent);
            }
        });

        ImageButton filterSearchButton2 = findViewById(R.id.filter_search_icon_button);
        filterSearchButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchProductController.this, FilterSearchController.class);
                startActivity(intent);
            }
        });



        /*
         * the following two textView and ImageButton objects created set
         * on click listeners and start new activity, so when user clicks on
         * for customer search text and/or button they are taken to the for
         * customer search page
         */
        TextView forCustomerSearchButton1 = findViewById(R.id.for_customer_search_text);
        forCustomerSearchButton1.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view){
               Intent intent = new Intent(SearchProductController.this, ForCustomerSearchController.class);
               startActivity(intent);
           }
        });

        ImageButton forCustomerSearchButton2 = findViewById(R.id.for_customer_search_icon_button);
        forCustomerSearchButton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view){
               Intent intent = new Intent(SearchProductController.this, ForCustomerSearchController.class);
               startActivity(intent);
           }
        });
    }

    /*
     * @param String filename
     *
     * loadTextFromAssets will take in a string filename and read the
     * contents within the file and append them to the text view do display
     * in the view
     */
    private String loadTextFromAssets(String filename){
        StringBuilder text = new StringBuilder();
        try{
            InputStream is = getAssets().open(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line = reader.readLine())!=null){
                text.append(line).append("\n");
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return text.toString();
    }
}
