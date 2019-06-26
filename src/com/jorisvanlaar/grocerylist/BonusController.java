package com.jorisvanlaar.grocerylist;

import javafx.fxml.FXML;

public class BonusController {

    @FXML
    private NumberTextField bonusField;

    public String getNewSerial(){
        String newSerial = bonusField.getText();
        return newSerial;
    }

    public NumberTextField getBonusField() {
        return bonusField;
    }
}
