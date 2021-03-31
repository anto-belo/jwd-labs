package com.epam.jwd.model;

public class Chocolate extends Sweet {
    double cacaoPercentage;
    ChocolateType type;

    public Chocolate(String name, double price, double sugar, double calories, double cacaoPercentage, ChocolateType type) {
        super(name, price, sugar, calories);
        this.cacaoPercentage = cacaoPercentage;
        this.type = type;
    }

    public double getCacaoPercentage() {
        return cacaoPercentage;
    }

    public void setCacaoPercentage(double cacaoPercentage) {
        this.cacaoPercentage = cacaoPercentage;
    }

    public ChocolateType getType() {
        return type;
    }

    public void setType(ChocolateType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "cacaoPercentage=" + cacaoPercentage +
                ", type=" + type +
                "} " + super.toString();
    }
}
