package com.epam.jwd;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static ChocolateCandy[] chocolateCandies;
    private static Lollipop[] lollipops;
    private static Jam[] jams;
    private static Pie[] pies;

    public static void main(String[] args) {
        fillSweetArrays();
        int i = 0;
        do {
            LOGGER.info(chocolateCandies[i++]);
        } while (i < chocolateCandies.length);

        for (Lollipop lollipop : lollipops) {
            LOGGER.info(lollipop);
        }

        for (Jam jam : jams) {
            LOGGER.info(jam);
        }

        for (Pie pie : pies) {
            LOGGER.info(pie);
        }
    }

    public static void fillSweetArrays() {
        SimpleSweetFactory factory = SweetFactory.newInstance();
        chocolateCandies = new ChocolateCandy[]{
                factory.chocolateCandy("A", 20.53, 9.4, 300,
                        Flavour.APPLE, ChocolateType.BLACK),
                factory.chocolateCandy("B", 19.3, 7.57, 253,
                        Flavour.CHERRY, ChocolateType.BLACK)
        };
        lollipops = new Lollipop[]{
                factory.lollipop("A", 0.4, 5, 120, Flavour.ORANGE,
                        DropFill.NONE, Lollipop.LollipopSize.MEDIUM),
                factory.lollipop("A", 0.78, 4.5, 124, Flavour.APPLE,
                        DropFill.NONE, Lollipop.LollipopSize.BIG),
                factory.lollipop("C", 0.65, 7.4, 133, Flavour.CHERRY,
                        DropFill.FIZZ, Lollipop.LollipopSize.BIG)
        };
        jams = new Jam[]{
                factory.jam("A", 5.4, 178, 543, Flavour.APPLE),
                factory.jam("B", 7.5, 234, 679, Flavour.CHERRY),
                factory.jam("C", 4.3, 231, 435, Flavour.STRAWBERRY)
        };
        pies = new Pie[]{
                factory.pie("A", 5.4, 305, 700, jams[0], 500),
                factory.pie("B", 7.4, 264, 648, jams[1], 563),
                factory.pie("C", 6.35, 353, 725, jams[2], 532)
        };
    }
}
