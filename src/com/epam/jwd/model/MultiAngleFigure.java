package com.epam.jwd.model;

import java.util.List;
import java.util.Objects;

public class MultiAngleFigure extends Figure {
    private final List<Point> points;

    MultiAngleFigure(List<Point> points) {
        figureType = FigureType.MULTI_ANGLE;
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MultiAngleFigure that = (MultiAngleFigure) o;

        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure{" +
                "figureType=" + figureType +
                ", figureProperties=" + figureProperties +
                ", points=" + points +
                '}';
    }
}
