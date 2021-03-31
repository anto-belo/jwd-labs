package com.epam.jwd.model;

public class Jam extends Sweet {
    Flavour flavour;

    public Jam(String name, double price, double sugar, double calories, Flavour flavour) {
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
        return "Jam{" +
                "flavour=" + flavour +
                "} " + super.toString();
    }
}
