package com.jorisvanlaar.grocerylist.test;

import com.jorisvanlaar.grocerylist.datamodel.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    private BonusCard bonusCard;
    private Customer customer;

    @Before
    public void setup() {
        bonusCard = new BonusCard("12345");
        customer = new Customer("Joris", bonusCard);
    }

    @Test
    public void getName() {
        assertEquals("Joris", customer.getName());
    }

    @Test
    public void getGroceryList() {
        assertNotNull(customer.getGroceryList());
    }

    @Test
    public void getBonusCard() {
        assertNotNull(customer.getBonusCard());
        assertEquals("12345", customer.getBonusCard().getBonusCardSerial());
    }

    @Test
    public void setBonusCard() {
        BonusCard newCard = new BonusCard("6789");
        customer.setBonusCard(newCard);
        assertEquals("6789",customer.getBonusCard().getBonusCardSerial());
    }

    @Test
    public void hasBonusCard() {
        assertTrue("The customer does NOT have a bonus card", customer.hasBonusCard());
    }
}