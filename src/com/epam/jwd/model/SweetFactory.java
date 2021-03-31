package com.epam.jwd.model;

public interface SweetFactory {

    static SimpleSweetFactory newInstance() {
        return SimpleSweetFactory.INSTANCE;
    }

    ChocolateCandy chocolateCandy(String name,
                                  double price,
                                  double sugar,
                                  double calories,
                                  Flavour flavour,
                                  ChocolateType chocolateType);

    Drop drop(String name,
              double price,
              double sugar,
              double calories,
              Flavour flavour,
              DropFill fill);

    Lollipop lollipop(String name,
                      double price,
                      double sugar,
                      double calories,
                      Flavour flavour,
                      DropFill fill,
                      Lollipop.LollipopSize size);

    Chocolate chocolate(String name,
                        double price,
                        double sugar,
                        double calories,
                        double cacaoPercentage,
                        ChocolateType type);

    Pie pie(String name,
            double price,
            double sugar,
            double calories,
            Jam fill,
            double weight);

    Jam jam(String name,
            double price,
            double sugar,
            double calories,
            Flavour flavour);
}
