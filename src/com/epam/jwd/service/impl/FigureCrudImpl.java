package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.ApplicationContext;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureStorage;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureCrud;
import com.epam.jwd.service.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum FigureCrudImpl implements FigureCrud {
    INSTANCE;

    private static final List<Figure> storage = FigureStorage.getInstance();

    @Override
    public Figure create(Figure.FigureType type, List<Point> points) throws FigureException {
        FigureFactory factory = ApplicationContext.INSTANCE;
        Optional<Figure> fig = Optional.empty();
        try {
            fig = Optional.of(factory.createFigure(type, points));
        } catch (FigureException e) {
            e.printStackTrace();
        }
        return fig.orElseThrow(() -> new FigureException("Figure can't be created"));
    }

    @Override
    public List<Figure> multiCreate(List<FigureEntry> figuresData) {
        FigureFactory factory = ApplicationContext.INSTANCE;
        List<Figure> figures = new ArrayList<>();
        for (FigureEntry fe : figuresData) {
            Optional<Figure> fig = Optional.empty();
            try {
                fig = Optional.of(factory.createFigure(fe.getType(), fe.getPoints()));
            } catch (FigureException e) {
                e.printStackTrace();
            }
            fig.ifPresent(figures::add);
        }
        return figures;
    }

    @Override
    public boolean delete(Figure figure) {
        return storage.remove(figure);
    }

    @Override
    public Figure delete(int index) {
        return storage.remove(index);
    }

    @Override
    public int find(Figure figure) {
        return storage.indexOf(figure);
    }

    @Override
    public Figure findById(int index) {
        return storage.get(index);
    }

    @Override
    public List<Figure> findByCriteria(SearchCriteria criteria) {
        return storage.stream().filter(criteria::isSuitsToCriteria).collect(Collectors.toList());
    }

    @Override
    public void update(Figure oldF, Figure newF) {
        storage.set(storage.indexOf(oldF), newF);
    }
}
