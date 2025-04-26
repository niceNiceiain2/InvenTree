package edu.utsa.cs4593.inventree.model;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Inventory {
    private HashMap<String, InventoryItem> itemsMap = new HashMap<String, InventoryItem>();
    private static Inventory inventory = null;

    public static Inventory getInventory() {
        return inventory;
    }

    public static void buildInventory(Context c) {
        inventory = new Inventory();
        inventory.loadInventory(c);
    }

    public void loadInventory(Context c) {
        AssetManager am = c.getAssets();
        InputStream inStream;

        try {
            inStream = am.open("data.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner scr = new Scanner(inStream);
        while (scr.hasNext()) {
            String line = scr.nextLine();
            StringTokenizer st = new StringTokenizer(line, ",");
            String name = st.nextToken();
            String quantity = st.nextToken();
            String lastAction = st.nextToken();

            InventoryItem ii = new InventoryItem( name, quantity, lastAction);

            addItem(ii);
        }
        System.out.println("Done!");
    }
    public void saveInventory(Context c) { }

    public void addItem(InventoryItem ii) {
        itemsMap.put(ii.getName(), ii);
    }

    public void deleteItem(String name) {
        itemsMap.remove(name);
    }

    public void updateItem(String name, InventoryItem ii) {
        itemsMap.remove(name);
        this.addItem(ii);
    }

    public InventoryItem getItem(String name) {
        return itemsMap.get(name);
    }
    public InventoryItem getItem(int i) {
        List<InventoryItem> list = this.getList();
        return list.get(i);
    }

    public List<InventoryItem> getList() {
        return itemsMap.values().stream().collect(Collectors.toList());
    }

    public int getSize() {
        return itemsMap.size();
    }
}
