package com.epam.jwd.storage;

import com.epam.jwd.model.Sweet;

import java.util.ArrayList;

public class SimpleSweetStorage {
    private static ArrayList<Sweet> storage;

    private SimpleSweetStorage() {
    }

    public static ArrayList<Sweet> getInstance() {
        if (storage == null) {
            storage = new ArrayList<>();
        }
        return storage;
    }
}
