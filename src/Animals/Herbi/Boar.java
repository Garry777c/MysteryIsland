package Animals.Herbi;

import Animals.Herbivorous;

public class Boar extends Herbivorous {
    public static final int maxAmountOnTheCell = 50;

    public Boar() {
        super();
        this.weight = 400;
        this.speed = 2;
        this.maxFoodToFeelGood = 50;
    }
}
