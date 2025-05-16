package edu.utsa.cs4593.inventree.controller;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import edu.utsa.cs4593.inventree.R;
import edu.utsa.cs4593.inventree.model.Product;

public class MultipleProductReturnController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multipleproductreturn);

        TableLayout tableLayout = findViewById(R.id.product_table);
        String json = getIntent().getStringExtra("filteredProducts");
        List<Product> filteredProducts = new Gson().fromJson(json, new TypeToken<List<Product>>(){}.getType());

        if (filteredProducts == null || filteredProducts.isEmpty()) {
            Toast.makeText(this, "No matching products found.", Toast.LENGTH_LONG).show();
            return; // Exit early so no table rows are added
        }

        for (Product product : filteredProducts) {
            TableRow row = new TableRow(this);
            TextView name = new TextView(this);
            name.setText(product.getName());
            name.setPadding(16, 16, 16, 16);
            name.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            ));
            TextView price = new TextView(this);
            price.setText(String.valueOf(product.getPrice()));
            price.setPadding(16, 16, 16, 16);
            price.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            ));
            row.addView(name);
            row.addView(price);
            tableLayout.addView(row);


        }
    }
}

