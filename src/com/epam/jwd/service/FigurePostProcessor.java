package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface FigurePostProcessor {
    static boolean isSimilarPoints(List<Point> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).equals(points.get(i + 1))) {
                return true;
            }
        }
        return points.get(0).equals(points.get(points.size() - 1));
    }

    static boolean isSimilarPoints(Figure figure) {
        List<Point> points;
        Figure.FigureType type = figure.getFigureType();
        switch (type) {
            case LINE:
                Line l = (Line) figure;
                points = new ArrayList<>(Arrays.asList(l.getStart(), l.getEnd()));
                break;
            case TRIANGLE:
                Triangle t = (Triangle) figure;
                points = new ArrayList<>(Arrays.asList(t.getA(), t.getB(), t.getC()));
                break;
            case SQUARE:
                Square s = (Square) figure;
                points = new ArrayList<>(Arrays.asList(s.getA(), s.getB(), s.getC(), s.getD()));
                break;
            case MULTI_ANGLE:
                MultiAngleFigure maf = (MultiAngleFigure) figure;
                points = maf.getPoints();
                break;
            default:
                throw new IllegalStateException("Unknown figure type: " + type.name());
        }
        return isSimilarPoints(points);
    }

    Figure process(Figure figure) throws FigureException;
}
