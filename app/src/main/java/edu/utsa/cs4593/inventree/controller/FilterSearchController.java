package edu.utsa.cs4593.inventree.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.List;
import java.util.Arrays;

import edu.utsa.cs4593.inventree.R;
import edu.utsa.cs4593.inventree.model.Inventory;
import edu.utsa.cs4593.inventree.model.Product;

public class FilterSearchController extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState){
        /*
         * sets the layout page for Filter search
         * which allows you to search for multiple products
         * by matching categories
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtersearch);

        Inventory inventory = new Inventory(this);

        Spinner categorySpinner = findViewById(R.id.category_dropdown);
        Spinner availabilitySpinner = findViewById(R.id.availability_dropdown);
        Spinner locationSpinner = findViewById(R.id.location_dropdown);
        Button filterButton = findViewById(R.id.apply_button);

        List<String> categoryList = inventory.getUniqueCategories();
        categoryList.add(0,"All");

        List<String> locationList = inventory.getUniqueLocations();
        locationList.add(0,"All");

        List<String> availabilityList = Arrays.asList("All", "In Stock", "Out Of Stock");

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoryList);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        categorySpinner.setAdapter(categoryAdapter);

        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locationList);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        ArrayAdapter<String> availabilityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, availabilityList);
        availabilityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        availabilitySpinner.setAdapter(availabilityAdapter);

        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCategory = categorySpinner.getSelectedItem().toString();
                String selectedLocation = locationSpinner.getSelectedItem().toString();
                String selectedAvailability = availabilitySpinner.getSelectedItem().toString();

                List<Product> filteredProducts = inventory.filterProducts(selectedCategory, selectedAvailability, selectedLocation);

                Intent intent = new Intent(FilterSearchController.this, MultipleProductReturnController.class);
                intent.putExtra("filteredProducts", new Gson().toJson(filteredProducts));
                startActivity(intent);
            }
        });

    }

}
