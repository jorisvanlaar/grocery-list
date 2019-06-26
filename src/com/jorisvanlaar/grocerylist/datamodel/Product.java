package com.jorisvanlaar.grocerylist.datamodel;

public abstract class Product {

    private String productName;
    private String productType;
    private double productPrice;
    private String formattedProductPrice;

    public Product(String productName, String productType, double productPrice) {
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.formattedProductPrice = "€" + productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getFormattedProductPrice() {
        return formattedProductPrice;
    }

    @Override
    public boolean equals(Object obj) {

        boolean result = obj instanceof Product;

        result = result && productName.equals( ((Product)obj).productName );
        result = result && productType.equals( ((Product)obj).productType );
        result = result && productPrice == ((Product)obj).productPrice ;
        result = result && formattedProductPrice.equals( ((Product)obj).formattedProductPrice );

        return result;
    }
}
