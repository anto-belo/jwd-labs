package com.epam.jwd.model;

public class Lollipop extends Drop {
    private LollipopSize size;

    public Lollipop(String name, double price, double sugar, double calories, Flavour flavour, DropFill fill, LollipopSize size) {
        super(name, price, sugar, calories, flavour, fill);
        this.size = size;
    }

    public LollipopSize getSize() {
        return size;
    }

    public void setSize(LollipopSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Lollipop{" +
                "size=" + size +
                "} " + super.toString();
    }

    public enum LollipopSize {
        SMALL, MEDIUM, BIG
    }
}
