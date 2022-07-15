package Animals.Carni;

import Animals.Carnivorous;
import General.Island;

public class Wolf extends Carnivorous {

    private static final int maxAmountOnTheCell = 30;

    public Wolf() {
        super();
        this.weight = 50;
        this.speed = 3;
        this.maxFoodToFeelGood = 8;
    }

}
