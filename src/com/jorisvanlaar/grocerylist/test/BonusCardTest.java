package com.jorisvanlaar.grocerylist.test;

import com.jorisvanlaar.grocerylist.datamodel.BonusCard;
import org.junit.Test;
import static org.junit.Assert.*;

public class BonusCardTest {

    @Test
    public void getBonusCardSerial() {
        BonusCard card = new BonusCard("12345");
        assertEquals("12345", card.getBonusCardSerial());
    }
}