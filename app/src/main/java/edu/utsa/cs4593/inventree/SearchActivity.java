package edu.utsa.cs4593.inventree;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs4593.inventree.controller.LogoutController;
import edu.utsa.cs4593.inventree.controller.SearchItemController;
import edu.utsa.cs4593.inventree.controller.SearchItemScreenController;

public class SearchActivity extends AppCompatActivity {
    public static EditText sku;

    public static String generateSKU(String categoryCode, String productCode, String variantCode) {
        return categoryCode + "-" + productCode + "-" + variantCode;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchproduct);

        ImageButton logout = findViewById(R.id.logoutButton2);
        logout.setOnClickListener(new LogoutController(getApplicationContext()));

        Button submit = findViewById(R.id.button3);
        sku=(EditText)findViewById(R.id.productSearchText);
        submit.setOnClickListener(new SearchItemController());
    }
}
