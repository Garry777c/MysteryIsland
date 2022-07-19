package Animals;

import Animals.Herbi.Caterpillar;
import General.*;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal{

    //general fields

    protected IslandCell location;
    protected float weight;
    protected int speed;
    protected float maxFoodToFeelGood;
    protected boolean isAlive;
//    protected Map<String, Integer> animalEatingTable;

    protected Animal() {
        this.isAlive = true;
        this.setLocation(StartIsland.randomCell());
    }



    //general methods
    public void eat(Object obj) {
        String whoEaten = obj.getClass().getSimpleName();
        String whoEats = this.getClass().getSimpleName();

        int possibility = AnimalTable.getInstance().returnPossibility(whoEats, whoEaten);

        System.out.println(whoEats + " eats "+ whoEaten +" with possibility "+ possibility +"%");
    }

    public void multiply(){
    }

    public void move(){
        IslandCell startPoint = this.getLocation();
        int newX = 0;
        int newY = 0;
        int speed = this.getSpeed();


        int directionMove = ThreadLocalRandom.current().nextInt(1,5); //1 -up, 2 - right, 3 - down, 4 - left

        switch (directionMove){
            case 1 ->{
                newX = startPoint.getX();
                int difference = (startPoint.getY()-speed);
                if (difference>=0) {
                    newY = difference;
                } else {
                    newY = (startPoint.getY()-(speed-Math.abs(difference)));
                }
                System.out.println("up");
            }

            case 2 ->{
                newY = startPoint.getY();
                int difference = (startPoint.getX()+speed);
                if(startPoint.getX() == StartIsland.myIsland.getLengthX()-1) {
                    newX = startPoint.getX();
                }
                else if (difference<StartIsland.myIsland.getLengthX()) {
                    newX = difference;
                } else {
                    newX = (startPoint.getX()+((StartIsland.myIsland.getLengthX()-1)-startPoint.getX()));
                }
                System.out.println("right");
            }

            case 3 -> {
                newX = startPoint.getX();
                int difference = (startPoint.getY() + speed);
                if(startPoint.getY() == StartIsland.myIsland.getLengthY()-1) {
                    newY = startPoint.getY();
                }
                else if (difference<StartIsland.myIsland.getLengthY()) {
                    newY = difference;
                } else {
                    newY = (startPoint.getY()+((StartIsland.myIsland.getLengthY()-1)-startPoint.getY()));
                }
                System.out.println("down");
            }

            case 4 -> {
                newY = startPoint.getY();
                int difference = (startPoint.getX()-speed);
                if (difference>=0) {
                    newX = difference;
                } else {
                    newX = (startPoint.getX()-(speed-Math.abs(difference)));
                }
                System.out.println("left");
            }

        }

        this.setLocation(StartIsland.myIsland.getMyMysteryIsland()[newY][newX]);

    }

    //getters setters

    public IslandCell getLocation() {
        return location;
    }

    public void setLocation(IslandCell location) {
        this.location = location;
    }

    public int getSpeed() {
        return speed;
    }



    //to String and hashcode
    @Override
    public String toString() {
        return "Animal: { " +
                this.getClass().getSimpleName() +
                 ", "+location +
                ", weight=" + weight +
                ", speed=" + speed +
                ", maxFoodToFeelGood=" + maxFoodToFeelGood +
                ", isAlive=" + isAlive +
                '}';
    }
}
