package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Line;

public class LinePropertiesStrategy implements FigurePropertiesStrategy {
    private static LinePropertiesStrategy strategy;

    private LinePropertiesStrategy() {
    }

    public static LinePropertiesStrategy getInstance() {
        if (strategy == null) {
            strategy = new LinePropertiesStrategy();
        }
        return strategy;
    }

    @Override
    public double getPerimeter(Figure figure) {
        Line line = (Line) figure;
        return FigurePropertiesStrategy.getPolylineLength(line.getStart(), line.getEnd());
    }

    @Override
    public double getArea(Figure figure) {
        return 0;
    }
}
