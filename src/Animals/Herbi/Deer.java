package Animals.Herbi;

import Animals.Herbivorous;

public class Deer extends Herbivorous {
    public static final int maxAmountOnTheCell = 20;

    public Deer() {
        super();
        this.weight = 300;
        this.speed = 4;
        this.maxFoodToFeelGood = 50;
    }
}
