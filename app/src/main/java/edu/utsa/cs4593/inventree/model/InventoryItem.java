package edu.utsa.cs4593.inventree.model;

public class InventoryItem {
    private String name="";
    private String qty="";
    private String lastAction="";

    public InventoryItem (String name, String qty, String lastAction) {
        this.name = name;
        this.qty = qty;
        this.lastAction = lastAction;
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
    public String getLastAction() {
        return lastAction;
    }
    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }
}
