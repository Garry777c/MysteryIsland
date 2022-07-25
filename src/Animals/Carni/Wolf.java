package Animals.Carni;

import Animals.Carnivorous;

import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Carnivorous {

    public static final int maxAmountOnTheCell = 30;
    public volatile static AtomicInteger count = new AtomicInteger();
    private static Wolf instance;

    private Wolf() {
        super();
        this.weight = 50;
        this.speed = 3;
        this.maxFoodToFeelGood = 8;
        Wolf.count.getAndIncrement();
    }

    public synchronized static Wolf returnWolf(){
        if (count.get() <= 30) {
            instance = new Wolf();
        }
        return instance;
    }

}
