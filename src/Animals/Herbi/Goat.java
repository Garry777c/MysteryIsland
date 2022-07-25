package Animals.Herbi;

import Animals.Herbivorous;

public class Goat extends Herbivorous {
    public static final int maxAmountOnTheCell = 140;

    public Goat() {
        super();
        this.weight = 60;
        this.speed = 3;
        this.maxFoodToFeelGood = 10;
    }
}
