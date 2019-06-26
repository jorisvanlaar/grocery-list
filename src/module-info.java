module GroceryList {

    requires javafx.fxml;
    requires javafx.controls;
    requires java.xml;
    requires junit;

    opens com.jorisvanlaar.grocerylist;
    opens com.jorisvanlaar.grocerylist.datamodel;
    opens com.jorisvanlaar.grocerylist.test;
}