package com.jorisvanlaar.grocerylist.test;

import com.jorisvanlaar.grocerylist.datamodel.*;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GroceryListTest {

    private GroceryList groceryList;
    private Product product1;
    private Product product2;
    private Product product3;

    @Before
    public void setup(){
        groceryList = new GroceryList();
        product1 = new Drink("Cola", 5);
        product2 = new Fruit("Mango", 7);
        groceryList.addProduct(product1);
        groceryList.addProduct(product2);
    }

    @Test
    public void getProducts() {

        ObservableList<Product> products1 = groceryList.getProducts();
        ObservableList<Product> products2 = groceryList.getProducts();

        products1.add(new Drink("Cola", 5));
        products1.add(new Fruit("Mango", 1.25));
        products1.add(new Meat("Hotdog", 2.99));

        products2.add(new Drink("Cola", 5));
        products2.add(new Fruit("Mango", 1.25));
        products2.add(new Meat("Hotdog", 2.99));

        assertEquals(products1, products2);
    }

    @Test
    public void addProduct() {
        product3 = new Vegetable("Tomato", 3.0);
        groceryList.addProduct(product3);
        assertEquals(15.0, groceryList.getTotalPrice(), 0);
    }

    @Test
    public void deleteProduct() {
        groceryList.deleteProduct(product2);
        assertEquals(5.0, groceryList.getTotalPrice(), 0);
    }

    @Test
    public void getTotalPrice() {
        assertEquals(12.0,groceryList.getTotalPrice(),0);
    }

    @Test
    public void getDiscountedTotalPrice() {
        assertEquals(10.8,groceryList.getDiscountedTotalPrice(),0);
    }

    @Test
    public void getDiscountedTotalPriceAfterDelete() {
        groceryList.deleteProduct(product2);
        assertEquals(4.5,groceryList.getDiscountedTotalPrice(),0);
    }
}