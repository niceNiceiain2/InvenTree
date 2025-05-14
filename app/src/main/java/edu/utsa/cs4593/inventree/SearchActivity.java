package edu.utsa.cs4593.inventree;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs4593.inventree.controller.ForCustomerSearchController;
import edu.utsa.cs4593.inventree.controller.LogoutController;
import edu.utsa.cs4593.inventree.controller.SearchItemController;

public class SearchActivity extends AppCompatActivity {
    public static EditText sku;

    public static String generateSKU(String categoryCode, String productCode, String variantCode) {
        return categoryCode + "-" + productCode + "-" + variantCode;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_product_id);

        ImageButton logout = findViewById(R.id.logOutButton);
        logout.setOnClickListener(new LogoutController(getApplicationContext()));

        Button submit = findViewById(R.id.search_button);
        sku=(EditText)findViewById(R.id.productSearchText);
        submit.setOnClickListener(new SearchItemController());
    }
}
