package com.epam.jwd.service;

import com.epam.jwd.model.Figure;

public interface SearchCriteria {
    boolean isSuitsToCriteria(Figure figure);
}
