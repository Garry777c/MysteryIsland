package Animals.Herbi;

import Animals.Herbivorous;

public class Mouse extends Herbivorous {
    private static final int maxAmountOnTheCell = 500;

    public Mouse() {
        super();
        this.weight = 0.05F;
        this.speed = 1;
        this.maxFoodToFeelGood = 0.01f;
    }
}
