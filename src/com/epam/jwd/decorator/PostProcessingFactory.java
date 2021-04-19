package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

import java.util.List;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private static final FigurePostProcessor postProcessor = new FigureExistencePostProcessor();
    private final FigureFactory factory;

    public PostProcessingFactory(FigureFactory factory) {
        this.factory = factory;
    }

    @Override
    public Figure createFigure(Figure.FigureType type, List<Point> figurePoints) throws FigureException {
        Figure figure = factory.createFigure(type, figurePoints);
        figure = postProcessor.process(figure);
        return figure;
    }
}
