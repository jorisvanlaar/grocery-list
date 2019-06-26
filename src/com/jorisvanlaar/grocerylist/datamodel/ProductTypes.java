package com.jorisvanlaar.grocerylist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductTypes {

    private ObservableList<String> productTypes;

    public ProductTypes() {
        productTypes = FXCollections.observableArrayList();
        productTypes.addAll("fruit", "vegetable", "meat", "drink");
    }

    public ObservableList<String> getProductTypes() {
        return productTypes;
    }
}
