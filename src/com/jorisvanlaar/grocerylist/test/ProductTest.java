package com.jorisvanlaar.grocerylist.test;

import com.jorisvanlaar.grocerylist.datamodel.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @Before
    public void setup(){
        product1 = new Drink("Cola",1.95);
        product2 = new Fruit("Mango",1.23);
        product3 = new Meat("Steak", 5.78 );
        product4 = new Vegetable("Sweet Potato", 3.0);
    }

    @Test
    public void getProductName() {
        assertEquals("Cola", product1.getProductName());
        assertEquals("Mango", product2.getProductName());
        assertEquals("Steak", product3.getProductName());
        assertEquals("Sweet Potato", product4.getProductName());
    }

    @Test
    public void getProductType() {
        assertEquals("drink", product1.getProductType());
        assertEquals("fruit", product2.getProductType());
        assertEquals("meat", product3.getProductType());
        assertEquals("vegetable", product4.getProductType());
    }

    @Test
    public void getProductPrice() {
        assertEquals(1.95, product1.getProductPrice(), 0);
        assertEquals(1.23, product2.getProductPrice(), 0);
        assertEquals(5.78, product3.getProductPrice(), 0);
        assertEquals(3.0, product4.getProductPrice(), 0);
    }

    @Test
    public void getFormattedProductPrice() {
        assertEquals("€1.95", product1.getFormattedProductPrice());
        assertEquals("€1.23", product2.getFormattedProductPrice());
        assertEquals("€5.78", product3.getFormattedProductPrice());
        assertEquals("€3.0", product4.getFormattedProductPrice());
    }
}