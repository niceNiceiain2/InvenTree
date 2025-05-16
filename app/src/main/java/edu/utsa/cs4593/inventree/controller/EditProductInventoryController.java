package edu.utsa.cs4593.inventree.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs4593.inventree.R;
import edu.utsa.cs4593.inventree.model.Inventory;
import edu.utsa.cs4593.inventree.model.Product;

public class EditProductInventoryController extends AppCompatActivity {

    private Inventory inventory;
    private Product loadedProduct;
    private TableLayout tableLayout;
    private EditText nameField, priceField, locationField, categoryField, stockField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product_inventory);

        inventory = new Inventory(this);

        EditText skuInput = findViewById(R.id.sku_input);
        Button loadButton = findViewById(R.id.load_product_button);
        Button applyChangesButton = findViewById(R.id.apply_changes_button);
        tableLayout = findViewById(R.id.product_edit_table);

        loadButton.setOnClickListener(v -> {
            String sku = skuInput.getText().toString().trim();
            loadedProduct = inventory.searchById(sku);

            if (loadedProduct == null) {
                Toast.makeText(this, "Product not found", Toast.LENGTH_SHORT).show();
                tableLayout.removeAllViews();
                applyChangesButton.setVisibility(View.GONE);
                return;
            }

            // Clear previous fields
            tableLayout.removeAllViews();

            // Add editable fields
            nameField = addRow("Name", loadedProduct.getName());
            priceField = addRow("Price", String.valueOf(loadedProduct.getPrice()));
            locationField = addRow("Location", loadedProduct.getLocation());
            categoryField = addRow("Category", loadedProduct.getCategory());
            stockField = addRow("Stock", String.valueOf(loadedProduct.getStockTag()));

            applyChangesButton.setVisibility(View.VISIBLE);
        });

        applyChangesButton.setOnClickListener(v -> {
            if (loadedProduct != null) {
                loadedProduct.setName(nameField.getText().toString().trim());
                loadedProduct.setPrice(priceField.getText().toString().trim());
                loadedProduct.setLocation(locationField.getText().toString().trim());
                loadedProduct.setCategory(categoryField.getText().toString().trim());
                loadedProduct.setStockTag(stockField.getText().toString().trim());

                inventory.updateProduct(loadedProduct);
                Toast.makeText(this, "Product updated successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Helper method to add a row with a label and an EditText
    private EditText addRow(String label, String value) {
        TableRow row = new TableRow(this);

        TextView labelView = new TextView(this);
        labelView.setText(label);
        labelView.setPadding(16, 16, 16, 16);

        EditText valueField = new EditText(this);
        valueField.setText(value);
        valueField.setPadding(16, 16, 16, 16);

        row.addView(labelView);
        row.addView(valueField);
        tableLayout.addView(row);

        return valueField;
    }
}

