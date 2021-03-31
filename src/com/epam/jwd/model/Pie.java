package com.epam.jwd.model;

public class Pie extends Sweet {
    Jam fill;
    double weight;

    public Pie(String name, double price, double sugar, double calories, Jam fill, double weight) {
        super(name, price, sugar, calories);
        this.fill = fill;
        this.weight = weight;
    }

    public Jam getFill() {
        return fill;
    }

    public void setFill(Jam fill) {
        this.fill = fill;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pie{" +
                "fillSweetArrays=" + fill +
                ", weight=" + weight +
                "} " + super.toString();
    }
}
