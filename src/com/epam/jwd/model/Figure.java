package com.epam.jwd.model;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public abstract class Figure {
    protected FigureType figureType;
    protected FigurePropertiesStrategy figureProperties;

    public FigureType getFigureType() {
        return figureType;
    }

    public enum FigureType {
        POINT(1), LINE(2), TRIANGLE(3), SQUARE(4), MULTI_ANGLE(5);

        private final int pointsCount;

        FigureType(int pointsCount) {
            this.pointsCount = pointsCount;
        }

        public int getPointsCount() {
            return pointsCount;
        }
    }
}
