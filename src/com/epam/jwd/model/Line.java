package com.epam.jwd.model;

import com.epam.jwd.strategy.LinePropertiesStrategy;

import java.util.Objects;

public class Line extends Figure {
    private final Point start;
    private final Point end;

    Line(Point start, Point end) {
        figureType = FigureType.LINE;
        figureProperties = LinePropertiesStrategy.getInstance();
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!Objects.equals(start, line.start)) return false;
        return Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "figureType=" + figureType +
                ", figureProperties=" + figureProperties +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
