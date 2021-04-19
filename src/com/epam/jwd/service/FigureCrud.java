package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import java.util.List;

public interface FigureCrud {
    Figure create(Figure.FigureType type, List<Point> points) throws FigureException;

    List<Figure> multiCreate(List<FigureEntry> figuresData);

    boolean delete(Figure figure);

    Figure delete(int index);

    int find(Figure figure);

    Figure findById(int index);

    List<Figure> findByCriteria(SearchCriteria criteria);

    void update(Figure oldF, Figure newF);

    class FigureEntry {
        private final Figure.FigureType type;
        private final List<Point> points;

        public FigureEntry(Figure.FigureType type, List<Point> points) {
            this.type = type;
            this.points = points;
        }

        public Figure.FigureType getType() {
            return type;
        }

        public List<Point> getPoints() {
            return points;
        }
    }
}
