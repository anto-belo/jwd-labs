package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;

import java.util.List;

public enum SimpleFigureFactory implements FigureFactory {
    INSTANCE;

    @Override
    public Figure createFigure(Figure.FigureType type, List<Point> figurePoints) throws FigureException {
        switch (type) {
            case LINE:
                return new Line(figurePoints.get(0), figurePoints.get(1));
            case TRIANGLE:
                return new Triangle(figurePoints.get(0), figurePoints.get(1), figurePoints.get(2));
            case SQUARE:
                return new Square(figurePoints.get(0), figurePoints.get(1), figurePoints.get(2), figurePoints.get(3));
            case MULTI_ANGLE:
                return new MultiAngleFigure(figurePoints);
            default:
                throw new FigureException("Unknown figure type: " + type.name());
        }
    }
}
