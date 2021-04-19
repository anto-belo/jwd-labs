package com.epam.jwd.factory;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import java.util.List;

public interface FigureFactory {
    Figure createFigure(Figure.FigureType type, List<Point> figurePoints) throws FigureException;
}
