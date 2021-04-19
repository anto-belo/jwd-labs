package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Square;

import static com.epam.jwd.strategy.FigurePropertiesStrategy.getPolylineLength;

public enum SquarePropertiesStrategy implements FigurePropertiesStrategy {
    INSTANCE;

    @Override
    public double getPerimeter(Figure figure) {
        Square s = (Square) figure;
        return getPolylineLength(s.getA(), s.getB(), s.getC(), s.getD());
    }

    @Override
    public double getArea(Figure figure) {
        Square s = (Square) figure;
        return Math.pow(s.getB().getY() - s.getA().getY(), 2);
    }
}
