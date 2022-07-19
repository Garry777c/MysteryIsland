package General;

import Animals.Animal;
import Animals.Carni.Wolf;
import Animals.Herbi.Boar;
import Animals.Herbi.Horse;
import Animals.Herbi.Rabbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class StartIsland {

    public static Island myIsland = Island.getInstance(); //create island instance
    public static ArrayList<Animal> animalList = new ArrayList<>();
    public static volatile HashSet<Animal> animalsOnCell = new HashSet<>();

    public static void main(String[] args) {



//        printCells(myIsland);
        animalList.add(new Wolf());
//        animalList.add(new Wolf());
        animalList.add(new Horse());
//        animalList.add(new Horse());
//        animalList.add(new Rabbit());
//        animalList.add(new Rabbit());

            for (Animal animal : animalList) {
            System.out.println(animal);
        }

        for(int i=0; i<myIsland.myMysteryIsland.length; i++){
            for (int j=0; j<myIsland.myMysteryIsland[i].length; j++){
                System.out.println("cell: " + myIsland.myMysteryIsland[i][j]);
                for (Animal animal : animalList) {
                    if (animal.getLocation().equals(myIsland.myMysteryIsland[i][j])) {
//                        System.out.println(animal);
                        animalsOnCell.add(animal);
                        System.out.println("in cell "+ animalsOnCell);
//                        animal.move();
//                        System.out.println("Im moving, my new coordinates: X:"+animal.getLocation().getX()+" Y:"+animal.getLocation().getY());
                    }
                }
                //run Threads from animalsOnCell here before move to another cell
            }
        }

//        for (Animal animal : animalList) {
//            System.out.println(animal);
//            animal.move();
//            System.out.println(animal);
//        }

    }

    public static void printCells (Island myIsland){
        for (IslandCell[] xxx : myIsland.myMysteryIsland) {
            for (IslandCell cell : xxx){
                System.out.println(cell);
            }
        }
    }

    //set random cell for each object
    public static IslandCell randomCell(){
        int x = ThreadLocalRandom.current().nextInt(0, myIsland.getLengthX());
        int y = ThreadLocalRandom.current().nextInt(0, myIsland.getLengthY());
        return myIsland.myMysteryIsland[y][x];
    }


}
