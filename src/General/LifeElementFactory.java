package General;

import Animals.Carni.*;
import Animals.Herbi.*;
import Animals.LifeElement;
import Animals.Plant;

//Animal Factory

public class LifeElementFactory {
    private LifeElement lifeElement;

    public LifeElement getAnimalByType (AnimalType type){
            this.lifeElement = switch (type) {
                case BEAR -> Bear.returnBear();
                case BOA -> Boa.returnBoa();
                case EAGLE -> Eagle.returnEagle();
                case FOX -> Fox.returnFox();
                case WOLF -> Wolf.returnWolf();
                case BOAR -> Boar.returnBoar();
                case BULL -> Bull.returnBull();
                case CATERPILLAR -> Caterpillar.returnCaterpillar();
                case DEER -> Deer.returnDeer();
                case DUCK -> Duck.returnDuck();
                case GOAT -> Goat.returnGoat();
                case HORSE -> Horse.returnHorse();
                case MOUSE -> Mouse.returnMouse();
                case RABBIT -> Rabbit.returnRabbit();
                case SHEEP -> Sheep.returnSheep();
                case PLANT -> Plant.returnPlant();
            };
        return lifeElement;
    }

}
