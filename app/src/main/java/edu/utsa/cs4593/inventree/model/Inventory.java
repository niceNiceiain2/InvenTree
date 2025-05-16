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

    /*
     * TODO: I WANT THE INVENTORY PAGE TO BE ABLE TO ACCESS THE
     *  ARRAY LIST OF PRODUCTS FROM PRODUCT CLASS
     */

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

    public List<Product> loadProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("College Textbook: Math 101","$89.99","Textbooks","123456789012","STRE-0000","In Stock","50","A3","N/A"));
        products.add(new Product("Blue Ink Pen","$1.50","School Supplies","889977665544","STRE-0005","In Stock","200","F3","N/A"));
        return products;
    }


//    private List<Product> products = new ArrayList<Product>();


//    private static Inventory inventory = null;
//
//    public static Inventory getInventory() {
//        return inventory;
//    }

//    public static void buildInventory(Context c) {
//        inventory = new Inventory();
//        inventory.loadInventory(c);
//    }
//
//    public void loadInventory(Context c) {
//        AssetManager am = c.getAssets();
//        InputStream inStream;
//
//        try {
//            inStream = am.open("product_details.csv");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Scanner scr = new Scanner(inStream);
//        while (scr.hasNext()) {
//            String line = scr.nextLine();
//            StringTokenizer st = new StringTokenizer(line, ",");
//            String name = st.nextToken();
//            String price = st.nextToken();
//            String category = st.nextToken();
//            String upc = st.nextToken();
//            String sku = st.nextToken();
//            String stockTag = st.nextToken();
//            String count = st.nextToken();
//            String location = st.nextToken();
//            String notes = st.nextToken();
//
//            Product ii = new Product( name, price, category, upc, sku, stockTag, count, location, notes);
//
//            addItem(ii);
//        }
//    }
//
//    public void addItem(Product ii) {
//        products.add(ii);
//    }
//
//    public void deleteItem(String sku) {
//        products.remove(sku);
//    }
//
//    public void updateItem(String sku, Product ii) {
//        products.remove(sku);
//        this.addItem(ii);
//    }
//
//    public List<Product> searchSKU(String sku) {
//        List<Product> newlist = new ArrayList<Product>();
//
//        for (Product item : products) {
//            if (item.getSku().contains(sku)) {
//                newlist.add(item);
//            }
//        }
//
//        return newlist;
//    }
//    public Product getItem(int i) {
//        List<Product> list = this.getList();
//        return list.get(i);
//    }
//
//    public List<Product> getList() {
//        return products;
//    }
//
//    public int getNumberOfItems() {
//        return products.size();
//    }
}