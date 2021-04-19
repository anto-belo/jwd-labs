package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.IllegalVertexesNumberException;
import com.epam.jwd.exception.NullPointException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import java.util.List;

public class PreProcessingFactory extends FigureFactoryDecorator {
    private final FigureFactory factory;

    public PreProcessingFactory(FigureFactory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(Figure.FigureType type, List<Point> figurePoints) throws FigureException {
        if (isAnyNulls(figurePoints)) {
            throw new NullPointException("Points array mustn't contain any null points");
        }
        if (type == Figure.FigureType.MULTI_ANGLE && figurePoints.size() < 3) {
            throw new IllegalVertexesNumberException("Figure of " + type.name()
                    + " type must consist of more than 3 points. Given " + figurePoints.size());
        } else if (type != Figure.FigureType.MULTI_ANGLE && type.getPointsCount() != figurePoints.size()) {
            throw new IllegalVertexesNumberException("Figure of " + type.name() + " type must consist of "
                    + type.getPointsCount() + " points. Given " + figurePoints.size());
        }
        return factory.createFigure(type, figurePoints);
    }

    private boolean isAnyNulls(List<Point> figurePoints) {
        for (Point p : figurePoints) {
            if (p == null) {
                return true;
            }
        }
        return false;
    }
}
