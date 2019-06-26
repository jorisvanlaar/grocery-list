package com.jorisvanlaar.grocerylist;

import com.jorisvanlaar.grocerylist.datamodel.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductController {

    @FXML
    private TextField productNameField;

    @FXML
    private ChoiceBox productTypeBox;

    @FXML
    private NumberTextField productPriceField;

    private ProductTypes productTypes;

    public void initialize(){

        productTypes = new ProductTypes();
        productNameField.setText("product");
        productTypeBox.setValue("fruit");
        productTypeBox.setItems(productTypes.getProductTypes());
        productPriceField.setText("0");
    }

    public Product getNewProduct(){
        String productName;
        String productType = productTypeBox.getValue().toString();
        Double productPrice;

        if (productNameField.getText().trim().isEmpty()){
            productName = "product";
        } else{
            productName = productNameField.getText();
        }

        if (productPriceField.getText().trim().isEmpty()){
            productPrice = 0.0;
        } else{
            productPrice = Double.valueOf(productPriceField.getText());
        }

        if (productType == "drink"){
            Product newProduct = new Drink(productName,productPrice);
            return newProduct;
        } else if (productType == "fruit"){
            Product newProduct = new Fruit(productName,productPrice);
            return newProduct;
        } else if (productType == "meat"){
            Product newProduct = new Meat(productName,productPrice);
            return newProduct;
        } else if (productType == "vegetable"){
            Product newProduct = new Vegetable(productName,productPrice);
            return newProduct;
        }else {
            return null;
        }
    }
}
