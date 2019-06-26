package com.jorisvanlaar.grocerylist.test;

import com.jorisvanlaar.grocerylist.datamodel.ProductTypes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTypesTest {

    private ProductTypes productTypes;

    @Before
    public void setup() {
        productTypes = new ProductTypes();
    }

    @Test
    public void getProductTypes() {
        ObservableList<String> expectedProductTypes = FXCollections.observableArrayList();
        expectedProductTypes.addAll("fruit", "vegetable", "meat", "drink");
        assertEquals(expectedProductTypes, productTypes.getProductTypes());
    }
}