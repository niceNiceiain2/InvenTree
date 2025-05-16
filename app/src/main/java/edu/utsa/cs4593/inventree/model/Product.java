package edu.utsa.cs4593.inventree.model;

import androidx.annotation.NonNull;

public class Product {

    /*
     *  TODO: I WANT TO BE ABLE TO CREATE THE ARRAY LIST OF PRODUCT
     *   OBJECTS FROM THE PRODUCT DETAILS CSV
     */
    private String name;
    private String price;
    private String category;
    private String upc;
    private String sku;
    private String stockTag;
    private String count;
    private String location;
    private String notes;

    public Product(String name, String price, String category, String upc, String sku, String stockTag, String count, String location,String notes){
        this.name = name;
        this.price = price;
        this.category = category;
        this.upc = upc;
        this.sku = sku;
        this.stockTag = stockTag;
        this.count = count;
        this.location = location;
        this.notes = notes;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }

    public String getCategory(){
        return category;
    }

    public String getUpc(){
        return upc;
    }

    public String getSku(){
        return sku;
    }

    public String getStockTag(){
        return stockTag;
    }

    public String getCount(){
        return count;
    }

    public String getLocation(){
        return location;
    }

    public String getNotes(){
        return notes;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setStockTag(String stockTag){
        this.stockTag = stockTag;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setLocation(String location){
        this.location = location;
    }

    @NonNull
    @Override
    public String toString(){
        return "Name: " + name + "\n" +
                "Price: " + price + "\n" +
                "Category: " + category + "\n" +
                "UPC: " + upc + "\n" +
                "SKU: " + sku + "\n" +
                "Stock Availability: " + stockTag + "\n" +
                "On Hand Count: " + count + "\n" +
                "Location: " + location + "\n" +
                "Notes: " + notes;
    }


}
