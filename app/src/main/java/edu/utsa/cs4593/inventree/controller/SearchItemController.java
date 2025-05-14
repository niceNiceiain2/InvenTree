package edu.utsa.cs4593.inventree.controller;

import static android.content.Intent.getIntent;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import java.util.List;

import edu.utsa.cs4593.inventree.SearchActivity;
import edu.utsa.cs4593.inventree.SearchResultsActivity;
import edu.utsa.cs4593.inventree.model.Inventory;

public class SearchItemController implements View.OnClickListener {

    /*
     * Sets the OnClick method and takes in the view.
     */
    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        String sku = SearchActivity.sku.getText().toString();

        Intent intent = new Intent(context, SearchResultsActivity.class);
        context.startActivity(intent);
    }
}