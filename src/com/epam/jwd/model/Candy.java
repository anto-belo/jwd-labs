package com.epam.jwd.model;

public abstract class Candy extends Sweet {
    private Flavour flavour;

    public Candy(String name, double price, double sugar, double calories, Flavour flavour) {
        super(name, price, sugar, calories);
        this.flavour = flavour;
    }

    public Flavour getFlavour() {
        return flavour;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "flavour=" + flavour +
                "} " + super.toString();
    }
}
