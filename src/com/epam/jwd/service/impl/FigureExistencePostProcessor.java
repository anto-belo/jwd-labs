package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;
import com.epam.jwd.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {
    @Override
    public Figure process(Figure figure) throws FigureException {
        if (FigurePostProcessor.isSimilarPoints(figure)) {
            throw new FigureNotExistException("Figure can't consist of similar points");
        }
        switch (figure.getFigureType()) {
            case TRIANGLE:
                Triangle t = (Triangle) figure;
                if (isOneLinePoints(t.getA(), t.getB(), t.getC())) {
                    throw new FigureNotExistException("Vertexes of triangle mustn't be located on the one line!");
                }
                break;
            case SQUARE:
                Square s = (Square) figure;
                if (!isCorrectSquareVertexes(s.getA(), s.getB(), s.getC(), s.getD())) {
                    throw new FigureNotExistException("Illegal positions for square vertexes");
                }
                break;
        }
        return figure;
    }

    private boolean isCorrectSquareVertexes(Point a, Point b, Point c, Point d) {
        return a.getX() == b.getX()
                && b.getY() == c.getY()
                && c.getX() == d.getX()
                && a.getY() == d.getY();
    }

    private boolean isOneLinePoints(Point a, Point b, Point c) {
        double k = (double) (b.getY() - a.getY()) / (b.getX() - a.getX());
        double d = a.getY() - k * a.getX();
        return c.getY() == k * c.getX() + d;
    }
}
