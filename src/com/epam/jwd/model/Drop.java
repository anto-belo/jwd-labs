package com.epam.jwd.model;

public class Drop extends Candy {
    DropFill fill;

    public Drop(String name, double price, double sugar, double calories, Flavour flavour, DropFill fill) {
        super(name, price, sugar, calories, flavour);
        this.fill = fill;
    }

    public DropFill getFill() {
        return fill;
    }

    public void setFill(DropFill fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return "Drop{" +
                "fillSweetArrays=" + fill +
                "} " + super.toString();
    }
}
