package edu.utsa.cs4593.inventree.model;

public class InventoryItem {
    private String name="";
    private String qty="";
    private String sku="";

    public InventoryItem (String name, String sku, String qty) {
        this.name = name;
        this.qty = qty;
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getQty() {
        return qty;
    }
    public void settQty(String qty) {
        this.qty = qty;
    }

    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
}
