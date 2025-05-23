package edu.utsa.cs4593.inventree.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs4593.inventree.R;
import edu.utsa.cs4593.inventree.model.Inventory;
import edu.utsa.cs4593.inventree.model.Product;

public class SearchProductIdController extends AppCompatActivity {

    public Inventory inventory;
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



        inventory = new Inventory(this);
        EditText searchField = findViewById(R.id.productSearchText);
        Button searchButton = findViewById(R.id.search_button);

       searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchField.getText().toString();
                Product result = inventory.searchById(query);

                if(result != null){
                    Intent intent = new Intent(SearchProductIdController.this, IndividualProductReturnController.class);
                    intent.putExtra("productDetails", result.toString());
                    startActivity(intent);
                }else {
                    Toast.makeText(SearchProductIdController.this, "Product not found!", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}
