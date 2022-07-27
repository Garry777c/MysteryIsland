package Animals;

import General.IslandCell;
import java.util.concurrent.Callable;


//top parent class
public class LifeElement implements Callable <LifeElement>{

    //fields
    protected IslandCell location;
    protected float weight;
    protected int speed;
    protected float maxFoodToFeelGood;
    protected boolean isAlive;
    protected float lifeAmount;

    public void move() {
    }

    public void eat() {
    }

    public void multiply(){
    }

    //getters setters
    public IslandCell getLocation() {
        return location;
    }

    public void setLocation(IslandCell location) {
        this.location = location;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public float getLifeAmount() {
        return lifeAmount;
    }

    public void setLifeAmount(float lifeAmount) {
        this.lifeAmount = lifeAmount;
    }

    @Override
    public LifeElement call() {
        eat();
        multiply();
        move();
        return this;
    }
}
