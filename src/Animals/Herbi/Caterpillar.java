package Animals.Herbi;

import Animals.Herbivorous;

public class Caterpillar extends Herbivorous {
    public static final int maxAmountOnTheCell = 1000;

    public Caterpillar() {
        super();
        this.weight = 0.01F;
        this.speed = 0;
        this.maxFoodToFeelGood = 0;
    }
}
