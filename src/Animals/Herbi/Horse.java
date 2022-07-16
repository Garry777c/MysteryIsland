package Animals.Herbi;

import Animals.Herbivorous;

public class Horse extends Herbivorous {
    public static final int maxAmountOnTheCell = 20;

    public Horse() {
        super();
        this.weight = 400;
        this.speed = 4;
        this.maxFoodToFeelGood = 60;
    }
}
