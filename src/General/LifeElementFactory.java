package General;

import Animals.Carni.*;
import Animals.Herbi.*;
import Animals.LifeElement;
import Animals.Plant;


public class LifeElementFactory {
    private LifeElement lifeElement;

    public LifeElement getAnimalByType (AnimalType type){
            this.lifeElement = switch (type) {
                case BEAR -> Bear.returnBear();
                case BOA -> new Boa();
                case EAGLE -> new Eagle();
                case FOX -> new Fox();
                case WOLF -> Wolf.returnWolf();
                case BOAR -> new Boar();
                case BULL -> new Bull();
                case CATERPILLAR -> new Caterpillar();
                case DEER -> new Deer();
                case DUCK -> new Duck();
                case GOAT -> new Goat();
                case HORSE -> new Horse();
                case MOUSE -> new Mouse();
                case RABBIT -> new Rabbit();
                case SHEEP -> new Sheep();
                case PLANT -> new Plant();
            };
        return lifeElement;
    }

//    public LifeElement getLifeElement() {
//        return lifeElement;
//    }
}
