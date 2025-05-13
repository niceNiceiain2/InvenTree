package edu.utsa.cs4593.inventree.model;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Inventory {
    private List<Product> products;

    public Inventory(List<Product> products){
        this.products = products;
    }

    public Product searchById(String query){
        for(Product product : products){
            if(product.getUpc().equals(query) || product.getSku().equals(query)){
                return product;
            }
        }
        return null;
    }

//    public List<Product> loadProducts(){
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("College Textbook: Math 101","$89.99","Textbooks","123456789012","STRE-0000","In Stock","50","A3","N/A"));
//        products.add(new Product("Blue Ink Pen","$1.50","School Supplies","889977665544","STRE-0005","In Stock","200","F3","N/A"));
//        return products;
//    }
}
