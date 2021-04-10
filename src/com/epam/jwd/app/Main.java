package com.epam.jwd.app;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static Point[] points;
    private static Line[] lines;
    private static Triangle[] triangles;
    private static Square[] squares;

    public static void main(String[] args) {
        fillFigureArrays();
        printPoints();
        printLines();
        printTriangles();
        printSquares();
    }

    private static void printSquares() {
        for (Square square : squares) {
            if (isSquare(square)) {
                LOGGER.info(square);
            } else {
                LOGGER.error(square + " does not exist!");
            }
        }
    }

    private static boolean isSquare(Square figure) {
        Point a = figure.getA();
        Point b = figure.getB();
        Point c = figure.getC();
        Point d = figure.getD();
        if (isSimilarPoints(a, b, c, d)) {
            LOGGER.error(figure + " is not a square!");
            return false;
        }
        return a.getX() == b.getX()
                && b.getY() == c.getY()
                && c.getX() == d.getX()
                && a.getY() == d.getY();
    }

    private static void printTriangles() {
        for (Triangle triangle : triangles) {
            if (isTriangle(triangle)) {
                LOGGER.info(triangle);
            } else {
                LOGGER.error(triangle + " does not exist!");
            }
        }
    }

    private static boolean isTriangle(Triangle figure) {
        Point a = figure.getA();
        Point b = figure.getB();
        Point c = figure.getC();
        if (isSimilarPoints(a, b, c)) {
            LOGGER.error(figure + " is not a triangle!");
            return false;
        }
        double k = (double) (b.getY() - a.getY()) / (b.getX() - a.getX());
        double d = a.getY() - k * a.getX();
        return c.getY() != k * c.getX() + d;
    }

    private static void printLines() {
        for (Line line : lines) {
            if (!isSimilarPoints(line.getStart(), line.getEnd())) {
                LOGGER.info(line);
            } else {
                LOGGER.error(line + " does not exist!");
            }
        }
    }

    private static void printPoints() {
        int i = 0;
        while (i < points.length) {
            LOGGER.info(points[i++]);
        }
    }

    private static boolean isSimilarPoints(Point... points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].equals(points[i + 1])) {
                return true;
            }
        }
        return points[0].equals(points[points.length - 1]);
    }

    private static void fillFigureArrays() {
        points = new Point[]{new Point(0, 1), new Point(1, 2), new Point(2, 3), new Point(3, 4)};
        lines = new Line[]{new Line(points[0], points[1]), new Line(points[1], points[2])};
        triangles = new Triangle[]{new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2)),
                new Triangle(new Point(0, 0), new Point(1, 2), new Point(3, 0))};
        squares = new Square[]{new Square(new Point(0, 0), new Point(0, 1),
                new Point(1, 1), new Point(1, 0)),
                new Square(new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 4))};
    }
}
