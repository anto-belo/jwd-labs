package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

public interface FigurePropertiesStrategy {
    static double getPolylineLength(Point... points) {
        double perimeter = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int dx = points[i + 1].getX() - points[i].getX();
            int dy = points[i + 1].getY() - points[i].getY();
            perimeter += Math.sqrt(dx * dx + dy * dy);
        }
        return perimeter;
    }

    static double[] getPolylineSidesLengths(Point a, Point b, Point... points) {
        double[] lengths = new double[points.length + 1];
        lengths[0] = getPolylineLength(a, b);
        for (int i = 1; i < lengths.length; i++) {
            lengths[i] = getPolylineLength(points[i - 1], points[i]);
        }
        return lengths;
    }

    double getPerimeter(Figure figure);

    double getArea(Figure figure);
}
