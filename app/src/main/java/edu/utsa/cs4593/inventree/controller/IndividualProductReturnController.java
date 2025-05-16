package edu.utsa.cs4593.inventree.controller;

import android.content.Intent;
import android.os.Bundle;
import edu.utsa.cs4593.inventree.R;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IndividualProductReturnController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individualproductreturn);

        TextView detailsText = findViewById(R.id.productDetailsText);
        String productDetails = getIntent().getStringExtra("productDetails");

        if(productDetails != null){
            detailsText.setText(productDetails);
        }else {
            detailsText.setText("No product details Found");
        }



        //TODO: ADD LOGOUT BUTTON FUNCTIONALITY
    }
}
