package Animals;

import General.IslandCell;
import General.StartIsland;

public class Plant{
    public static final int maxAmountOnTheCell = 200;

    protected IslandCell location;
    protected float weight;
    protected boolean isAlive;

    public Plant() {
        this.isAlive = true;
        this.setLocation(StartIsland.randomCell());
    }




    //getter setters
    public void setLocation(IslandCell location) {
        this.location = location;
    }

    public IslandCell getLocation() {
        return location;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
