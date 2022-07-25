package Animals.Carni;

import Animals.Carnivorous;

public class Eagle extends Carnivorous {
    public static final int maxAmountOnTheCell = 20;

    public Eagle() {
        super();
        this.weight = 6;
        this.speed = 3;
        this.maxFoodToFeelGood = 1;
    }
}
