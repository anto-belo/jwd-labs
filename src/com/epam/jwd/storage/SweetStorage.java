package com.epam.jwd.storage;

import com.epam.jwd.model.Sweet;

public interface SweetStorage {
    
    Sweet get(Sweet sweet);

    void add(Sweet sweet);
}
