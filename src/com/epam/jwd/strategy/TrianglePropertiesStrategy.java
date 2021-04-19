package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Triangle;

import static com.epam.jwd.strategy.FigurePropertiesStrategy.getPolylineLength;
import static com.epam.jwd.strategy.FigurePropertiesStrategy.getPolylineSidesLengths;

public enum TrianglePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double getPerimeter(Figure figure) {
        Triangle t = (Triangle) figure;
        return getPolylineLength(t.getA(), t.getB(), t.getC());
    }

    @Override
    public double getArea(Figure figure) {
        Triangle t = (Triangle) figure;
        Point a = t.getA();
        Point b = t.getB();
        Point c = t.getC();
        double[] l = getPolylineSidesLengths(a, b, c);
        double p = (l[0] + l[1] + l[2]) / 2;
        return Math.sqrt(p * (p - l[0]) * (p - l[1]) * (p - l[2]));
    }
}
