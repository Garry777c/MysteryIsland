package Animals.Herbi;

import Animals.Herbivorous;

public class Bull extends Herbivorous {
    public static final int maxAmountOnTheCell = 10;

    public Bull() {
        super();
        this.weight = 700;
        this.speed = 3;
        this.maxFoodToFeelGood = 100;
    }
}
