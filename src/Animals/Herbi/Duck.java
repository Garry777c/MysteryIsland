package Animals.Herbi;

import Animals.Herbivorous;

public class Duck extends Herbivorous {
    public static final int maxAmountOnTheCell = 200;

    public Duck() {
        super();
        this.weight = 1;
        this.speed = 4;
        this.maxFoodToFeelGood = 0.15F;
    }
}
