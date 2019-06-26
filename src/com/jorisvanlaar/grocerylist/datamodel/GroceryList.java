package com.jorisvanlaar.grocerylist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GroceryList {

    private ObservableList<Product> products;
    private double totalPrice;
    private double discountedTotalPrice;

    public GroceryList(){
        this.totalPrice = 0;
        this.discountedTotalPrice = 0;
        products = FXCollections.observableArrayList();
    }

    public ObservableList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
        totalPrice += product.getProductPrice();
    }

    public void deleteProduct(Product product){
        products.remove(product);
        totalPrice -= product.getProductPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscountedTotalPrice() {
        discountedTotalPrice = totalPrice - (totalPrice/10);
        return discountedTotalPrice;
    }
}
