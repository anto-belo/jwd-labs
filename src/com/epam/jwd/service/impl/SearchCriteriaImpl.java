package com.epam.jwd.service.impl;

import com.epam.jwd.model.*;
import com.epam.jwd.service.SearchCriteria;

import java.util.Arrays;
import java.util.List;

public class SearchCriteriaImpl implements SearchCriteria {
    final Figure.FigureType type;
    final List<Point> points;

    public SearchCriteriaImpl(Figure.FigureType type, List<Point> points) {
        this.type = type;
        this.points = points;
    }

    @Override
    public boolean isSuitsToCriteria(Figure figure) {
        if (type != null && !figure.getFigureType().equals(type)) {
            return false;
        }
        if (points != null) {
            switch (figure.getFigureType()) {
                case LINE:
                    Line l = (Line) figure;
                    return Arrays.asList(l.getStart(), l.getEnd()).containsAll(points);
                case TRIANGLE:
                    Triangle t = (Triangle) figure;
                    return Arrays.asList(t.getA(), t.getB(), t.getC()).containsAll(points);
                case SQUARE:
                    Square s = (Square) figure;
                    return Arrays.asList(s.getA(), s.getB(), s.getC(), s.getD()).containsAll(points);
                case MULTI_ANGLE:
                    MultiAngleFigure maf = (MultiAngleFigure) figure;
                    return maf.getPoints().containsAll(points);
            }
        }
        return true;
    }

}
