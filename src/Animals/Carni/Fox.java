package Animals.Carni;

import Animals.Carnivorous;

public class Fox extends Carnivorous {
    public static final int maxAmountOnTheCell = 30;

    public Fox() {
        super();
        this.weight = 8;
        this.speed = 2;
        this.maxFoodToFeelGood = 2;
    }
}
