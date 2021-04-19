package com.epam.jwd.model;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;

import java.util.List;

public enum ApplicationContext implements FigureFactory {
    INSTANCE;

    @Override
    public Figure createFigure(Figure.FigureType type, List<Point> figurePoints) throws FigureException {
        return new PostProcessingFactory(
                new PreProcessingFactory(
                        SimpleFigureFactory.INSTANCE
                )
        ).createFigure(type, figurePoints);
    }
}
