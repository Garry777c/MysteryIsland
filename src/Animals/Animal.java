package Animals;

import General.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends LifeElement{

    //general fields
    protected IslandCell location;
    protected float weight;
    protected int speed;
    protected float maxFoodToFeelGood;
    protected boolean isAlive;
    ArrayList<LifeElement> animalToDo;

    protected Animal() {
        this.isAlive = true;
        this.lifeAmount = 100;
        this.setLocation(StartIsland.randomCell());
    }

    //general methods
    public synchronized void eat() {
        setAnimalToDo(StartIsland.animalsOnCell);
        while (this.animalToDo == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        float currentLife = this.lifeAmount;

        //get all animals/plants on the cell
        for (LifeElement toEat : animalToDo) {
            String whoEaten = toEat.getClass().getSimpleName();
            String whoEats = this.getClass().getSimpleName();
            if (whoEaten.equals(whoEats)) continue;//don't run method if they are same type

            //random possibility and pull the possibility table for this Type of Animal
            int randomPossibility = ThreadLocalRandom.current().nextInt(0, 101);
            int possibility = AnimalTable.getInstance().returnPossibility(whoEats, whoEaten);

            //check if the one can eat another one
            if ((possibility>randomPossibility)&&(toEat.isAlive())) {
                System.out.println(whoEats + " ate " + whoEaten);
                toEat.setAlive(false);

                if (this.lifeAmount<=0) this.setAlive(false);

                //random condition to eat
                if(this.lifeAmount<80 && this.lifeAmount>0) {
                    float factor = this.maxFoodToFeelGood/toEat.weight;
                    float extra = (factor>=1)? 20 : (factor*10);
                    this.lifeAmount = currentLife + extra;
                    if (this.lifeAmount > 100) {
                        this.setLifeAmount(100f);
                    }
                }
            }
        }
    }

    public synchronized void multiply(){
        setAnimalToDo(StartIsland.animalsOnCell);

        while (this.animalToDo == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (LifeElement toMultiply : animalToDo) {
            String dad = toMultiply.getClass().getSimpleName();
            String mom = this.getClass().getSimpleName();

            if (dad.equals("Plant")) continue; //if it's plant don't multiply

            //multiply with 10% possibility
            if ((dad.equals(mom)) && (StartIsland.counter<=StartIsland.maxNewBorn)) {
                if (ThreadLocalRandom.current().nextInt(0,11) == 0)
                {
                    StartIsland.animalList.add(StartIsland.lifeElementFactory.getAnimalByType(AnimalType
                            .valueOf(dad.toUpperCase())));
                    System.out.println("New "+dad+ " was born!");
                    StartIsland.counter++;
                    }
               }
            }
      }

    public synchronized void move(){

        IslandCell startPoint = this.getLocation();
        int newX = 0;
        int newY = 0;
        int speed = this.getSpeed();

        //random direction
        int directionMove = ThreadLocalRandom.current().nextInt(1,5); //1 -up, 2 - right, 3 - down, 4 - left

        switch (directionMove) {
            case 1 -> {
                newX = startPoint.getX();
                int difference = (startPoint.getY() - speed);
                if (difference >= 0) {
                    newY = difference;
                } else {
                    newY = (startPoint.getY() - (speed - Math.abs(difference)));
                }
                System.out.println(this.getClass().getSimpleName()+" goes up");
            }

            case 2 -> {
                newY = startPoint.getY();
                int difference = (startPoint.getX() + speed);
                if (startPoint.getX() == StartIsland.myIsland.getLengthX() - 1) {
                    newX = startPoint.getX();
                } else if (difference < StartIsland.myIsland.getLengthX()) {
                    newX = difference;
                } else {
                    newX = (startPoint.getX() + ((StartIsland.myIsland.getLengthX() - 1) - startPoint.getX()));
                }
                System.out.println(this.getClass().getSimpleName()+" goes right");
            }

            case 3 -> {
                newX = startPoint.getX();
                int difference = (startPoint.getY() + speed);
                if (startPoint.getY() == StartIsland.myIsland.getLengthY() - 1) {
                    newY = startPoint.getY();
                } else if (difference < StartIsland.myIsland.getLengthY()) {
                    newY = difference;
                } else {
                    newY = (startPoint.getY() + ((StartIsland.myIsland.getLengthY() - 1) - startPoint.getY()));
                }
                System.out.println(this.getClass().getSimpleName()+" goes down");
            }

            case 4 -> {
                newY = startPoint.getY();
                int difference = (startPoint.getX() - speed);
                if (difference >= 0) {
                    newX = difference;
                } else {
                    newX = (startPoint.getX() - (speed - Math.abs(difference)));
                }
                System.out.println(this.getClass().getSimpleName()+" goes left");
            }

        }

        this.setLocation(StartIsland.myIsland.getMyMysteryIsland()[newY][newX]);
        this.setLifeAmount(this.lifeAmount-10); //each cycle takes 10% of the life
        if (this.lifeAmount<=0) this.setAlive(false);
    }


    //getters setters
    public ArrayList<LifeElement> getAnimalToDo() {
        return animalToDo;
    }

    public synchronized void setAnimalToDo(ArrayList<LifeElement> animalToDo) {
        this.animalToDo = animalToDo;
    }

    public IslandCell getLocation() {
        return location;
    }

    public void setLocation(IslandCell location) {
        this.location = location;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    //to String and hashcode
    @Override
    public String toString() {
        return "Animal: { " +
                this.getClass().getSimpleName() +
                 ", "+location +
                " life "+lifeAmount+ "%"+
                '}';
    }
}
