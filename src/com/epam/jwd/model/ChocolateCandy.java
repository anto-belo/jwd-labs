package com.epam.jwd.model;

public class ChocolateCandy extends Candy {
    private ChocolateType chocolateType;

    public ChocolateCandy(String name, double price, double sugar, double calories, Flavour flavour, ChocolateType chocolateType) {
        super(name, price, sugar, calories, flavour);
        this.chocolateType = chocolateType;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                "chocolateType=" + chocolateType +
                "} " + super.toString();
    }
}
