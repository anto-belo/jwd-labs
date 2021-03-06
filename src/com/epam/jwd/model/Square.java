package com.epam.jwd.model;

import com.epam.jwd.strategy.SquarePropertiesStrategy;

import java.util.Objects;

public class Square extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    Square(Point a, Point b, Point c, Point d) {
        figureType = FigureType.SQUARE;
        figureProperties = SquarePropertiesStrategy.INSTANCE;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    public Point getD() {
        return d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (!Objects.equals(a, square.a)) return false;
        if (!Objects.equals(b, square.b)) return false;
        if (!Objects.equals(c, square.c)) return false;
        return Objects.equals(d, square.d);
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Square{" +
                "figureType=" + figureType +
                ", figureProperties=" + figureProperties +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
