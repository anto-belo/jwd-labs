package com.epam.jwd.service.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.SearchCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriteriaBuilder {
    Figure.FigureType type;
    final List<Point> points;

    public CriteriaBuilder() {
        points = new ArrayList<>();
    }

    public CriteriaBuilder instanceOf(Figure.FigureType type) {
        this.type = type;
        return this;
    }

    public CriteriaBuilder containsPoint(Point p) {
        this.points.add(p);
        return this;
    }

    public CriteriaBuilder containsPoints(Point... points) {
        this.points.addAll(Arrays.asList(points));
        return this;
    }

    public SearchCriteria getResult() {
        return new SearchCriteriaImpl(type, points);
    }
}
