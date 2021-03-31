package com.epam.jwd.model;

import com.epam.jwd.storage.SimpleSweetStorage;
import com.epam.jwd.storage.SweetStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public enum SimpleSweetFactory implements SweetFactory, SweetStorage {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger(SimpleSweetFactory.class);

    @Override
    public Sweet get(Sweet sweet) {
        ArrayList<Sweet> storage = SimpleSweetStorage.getInstance();
        int index = storage.indexOf(sweet);
        return (index != -1) ? storage.get(index) : null;
    }

    @Override
    public void add(Sweet sweet) {
        SimpleSweetStorage.getInstance().add(sweet);
    }

    @Override
    public ChocolateCandy chocolateCandy(String name, double price, double sugar, double calories, Flavour flavour,
                                         ChocolateType chocolateType) {
        ChocolateCandy sweet = new ChocolateCandy(name, price, sugar, calories, flavour, chocolateType);
        ChocolateCandy result = (ChocolateCandy) get(sweet);
        if (result != null) {
            LOGGER.error("Trying to create existing ChocolateCandy obj: " + sweet.getName());
            return result;
        }
        add(sweet);
        return sweet;
    }

    @Override
    public Drop drop(String name, double price, double sugar, double calories, Flavour flavour, DropFill fill) {
        Drop sweet = new Drop(name, price, sugar, calories, flavour, fill);
        Drop result = (Drop) get(sweet);
        if (result != null) {
            LOGGER.error("Trying to create existing Drop obj: " + sweet.getName());
            return result;
        }
        add(sweet);
        return sweet;
    }

    @Override
    public Lollipop lollipop(String name, double price, double sugar, double calories, Flavour flavour, DropFill fill,
                             Lollipop.LollipopSize size) {
        Lollipop sweet = new Lollipop(name, price, sugar, calories, flavour, fill, size);
        Lollipop result = (Lollipop) get(sweet);
        if (result != null) {
            LOGGER.error("Trying to create existing Lollipop obj: " + sweet.getName());
            return result;
        }
        add(sweet);
        return sweet;
    }

    @Override
    public Chocolate chocolate(String name, double price, double sugar, double calories, double cacaoPercentage,
                               ChocolateType type) {
        Chocolate sweet = new Chocolate(name, price, sugar, calories, cacaoPercentage, type);
        Chocolate result = (Chocolate) get(sweet);
        if (result != null) {
            LOGGER.error("Trying to create existing Chocolate obj: " + sweet.getName());
            return result;
        }
        add(sweet);
        return sweet;
    }

    @Override
    public Pie pie(String name, double price, double sugar, double calories, Jam fill, double weight) {
        Pie sweet = new Pie(name, price, sugar, calories, fill, weight);
        Pie result = (Pie) get(sweet);
        if (result != null) {
            LOGGER.error("Trying to create existing Pie obj: " + sweet.getName());
            return result;
        }
        add(sweet);
        return sweet;
    }

    @Override
    public Jam jam(String name, double price, double sugar, double calories, Flavour flavour) {
        Jam sweet = new Jam(name, price, sugar, calories, flavour);
        Jam result = (Jam) get(sweet);
        if (result != null) {
            LOGGER.error("Trying to create existing Jam obj: " + sweet.getName());
            return result;
        }
        add(sweet);
        return sweet;
    }
}
