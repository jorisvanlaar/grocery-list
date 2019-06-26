package com.jorisvanlaar.grocerylist.datamodel;

public class Customer {

    private String name;
    private GroceryList groceryList;
    private BonusCard bonusCard;

    public Customer(String name){
        this.name = name;
        this.groceryList = new GroceryList();
    }

    public Customer(String name, BonusCard bonusCard) {
        this(name);
        this.bonusCard = bonusCard;
    }

    public String getName() {
        return name;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public BonusCard getBonusCard() {
        return bonusCard;
    }

    public void setBonusCard(BonusCard bonusCard) {
        this.bonusCard = bonusCard;
    }

    public boolean hasBonusCard(){
        if (bonusCard != null) {
            return true;
        } else {
            return false;
        }
    }
}
