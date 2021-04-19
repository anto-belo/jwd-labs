package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;

public class FigureStorage {
    private static List<Figure> storage;

    private FigureStorage() {
    }

    public static List<Figure> getInstance() {
        if (storage == null) {
            storage = new ArrayList<>();
        }
        return storage;
    }
}
