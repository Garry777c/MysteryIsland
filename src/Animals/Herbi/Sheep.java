package Animals.Herbi;

import Animals.Herbivorous;

public class Sheep extends Herbivorous {
    public static final int maxAmountOnTheCell = 140;

    public Sheep() {
        super();
        this.weight = 70;
        this.speed = 3;
        this.maxFoodToFeelGood = 15;
    }
}
