package edu.utsa.cs4593.inventree.model;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Inventory {
    private List<Product> products;

    /*
     * constructor that loads the products from csv
     */
    public Inventory(Context context) {
        this.products = loadProductsFromCSV(context);
    }

    /*
     * loadProductsFromCSV loads products from
     * assets/products_details.csv
     */
    private List<Product> loadProductsFromCSV(Context context) {
        List<Product> loadedProducts = new ArrayList<>();

        try {
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("product_details.csv");
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");

                if (fields.length < 9) continue;

                Product product = new Product(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8]);

                loadedProducts.add(product);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loadedProducts;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product searchById(String query) {
        for (Product product : products) {
            if (product.getUpc().equals(query) || product.getSku().equals(query)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteItem(String sku) {
        products.removeIf(p -> p.getSku().equalsIgnoreCase(sku));
    }

    public void updateItem(String sku, Product updatedProduct) {
        deleteItem(sku);
        addProduct(updatedProduct);
    }

    public List<String> getUniqueCategories() {
        Set<String> categories = new HashSet<>();
        for (Product p : products) {
            categories.add(p.getCategory());
        }
        return new ArrayList<>(categories);
    }

    public List<String> getUniqueLocations() {
        Set<String> locations = new HashSet<>();
        for (Product p : products) {
            locations.add(p.getLocation());
        }
        return new ArrayList<>(locations);
    }

    public Product getProductBySku(String sku) {
        for (Product p : products) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null;
    }

    public void updateProduct(Product updated) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getSku().equals(updated.getSku())) {
                products.set(i, updated);
                break;
            }
        }
    }

    public List<Product> filterProducts(String category, String availability, String location) {
        List<Product> results = new ArrayList<>();
        for (Product p : products) {
            boolean match = true;

            if (!category.equals("All") && !p.getCategory().equals(category)) {
                match = false;
            }
            if (!location.equals("All") && !p.getLocation().equals(location)) {
                match = false;
            }
            if (!availability.equals("All")) {
                if (availability.equals("In Stock") && !p.getStockTag().equalsIgnoreCase("In Stock")) {
                    match = false;
                } else if (availability.equals("Out of Stock") && !p.getStockTag().equalsIgnoreCase("Out Of Stock")) {
                    match = false;
                }
            }
            if (match) {
                results.add(p);
            }

        }
        return results;
    }
}

//    public List<Product> loadProducts(){
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("College Textbook: Math 101","$89.99","Textbooks","123456789012","STRE-0000","In Stock","50","A3","N/A"));
//        products.add(new Product("Blue Ink Pen","$1.50","School Supplies","889977665544","STRE-0005","In Stock","200","F3","N/A"));
//        return products;
//    }
