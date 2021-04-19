package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureStorage;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureCrud;
import com.epam.jwd.service.SearchCriteria;
import com.epam.jwd.service.impl.CriteriaBuilder;
import com.epam.jwd.service.impl.FigureCrudImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            fillFigureArrays();
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }

        CriteriaBuilder cb = new CriteriaBuilder();
        SearchCriteria sc = cb.instanceOf(Figure.FigureType.SQUARE).containsPoint(new Point(0, 0)).getResult();
        FigureCrud fc = FigureCrudImpl.INSTANCE;
        fc.findByCriteria(sc).forEach(System.out::println);
    }

    private static void fillFigureArrays() throws FigureException {
        FigureCrud factory = FigureCrudImpl.INSTANCE;
        List<Figure> figures = FigureStorage.getInstance();

        figures.add(new Point(0, 1));
        figures.add(new Point(1, 2));
        figures.add(new Point(2, 3));
        figures.add(new Point(3, 4));

        figures.addAll(
                factory.multiCreate(
                        Arrays.asList(
                                new FigureCrud.FigureEntry(Figure.FigureType.LINE,
                                        Arrays.asList(
                                                new Point(0, 1),
                                                new Point(1, 2)
                                        )
                                ),
                                new FigureCrud.FigureEntry(
                                        Figure.FigureType.LINE,
                                        Arrays.asList(
                                                new Point(2, 3),
                                                new Point(3, 4)
                                        )
                                )
                        )
                )
        );

        figures.add(factory.create(Figure.FigureType.TRIANGLE,
                Arrays.asList(
                        new Point(0, 0),
                        new Point(1, 1),
                        new Point(2, 3)
                )
        ));
        figures.add(factory.create(Figure.FigureType.TRIANGLE,
                Arrays.asList(
                        new Point(0, 0),
                        new Point(1, 2),
                        new Point(3, 0)
                )
        ));

        figures.add(factory.create(Figure.FigureType.SQUARE,
                Arrays.asList(
                        new Point(0, 0),
                        new Point(0, 1),
                        new Point(1, 1),
                        new Point(1, 0)
                )
        ));
        figures.add(factory.create(Figure.FigureType.SQUARE,
                Arrays.asList(
                        new Point(0, 0),
                        new Point(0, 1),
                        new Point(1, 1),
                        new Point(1, 0)
                )
        ));

        figures.add(factory.create(Figure.FigureType.MULTI_ANGLE,
                Arrays.asList(
                        new Point(0, 0),
                        new Point(1, 2),
                        new Point(2, 1),
                        new Point(3, 3),
                        new Point(5, 0)
                )
        ));
        figures.add(factory.create(Figure.FigureType.MULTI_ANGLE,
                Arrays.asList(
                        new Point(0, 0),
                        new Point(0, 1),
                        new Point(2, 1),
                        new Point(3, 3),
                        new Point(5, 0),
                        new Point(3, 1)
                )
        ));
    }
}
