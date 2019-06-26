package com.jorisvanlaar.grocerylist;

import javafx.scene.control.TextField;

public class NumberTextField extends TextField {

    public NumberTextField(){
        this.setPromptText("Enter only numbers");
    }

    @Override
    public void replaceText(int start, int end, String text){
        if(text.matches("[0.00-9.99]") || text.isEmpty()){
            super.replaceText(start,end,text);
        }
    }
}
