package com.epam.jwd.model;

import com.epam.jwd.strategy.TrianglePropertiesStrategy;

import java.util.Objects;

public class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;

    Triangle(Point a, Point b, Point c) {
        figureType = FigureType.TRIANGLE;
        figureProperties = TrianglePropertiesStrategy.INSTANCE;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!Objects.equals(a, triangle.a)) return false;
        if (!Objects.equals(b, triangle.b)) return false;
        return Objects.equals(c, triangle.c);
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "figureType=" + figureType +
                ", figureProperties=" + figureProperties +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
