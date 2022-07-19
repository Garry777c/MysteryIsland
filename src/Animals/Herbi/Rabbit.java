package Animals.Herbi;

import Animals.Herbivorous;

public class Rabbit extends Herbivorous {
    public static final int maxAmountOnTheCell = 150;

    public Rabbit() {
        super();
        this.weight = 2;
        this.speed = 2;
        this.maxFoodToFeelGood = 0.45F;
    }
}
