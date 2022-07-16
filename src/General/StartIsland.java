package General;

import Animals.Animal;
import Animals.Carni.Wolf;
import Animals.Herbi.Boar;
import Animals.Herbi.Horse;

import java.util.concurrent.ThreadLocalRandom;

public class StartIsland {

    public static Island myIsland = Island.getInstance(); //create island instance

    public static void main(String[] args) {



//        printCells(myIsland);

        Animal wolf1 = new Wolf();
        Animal boar1 = new Boar();
        Animal horse1 = new Horse();

        System.out.println(wolf1);
        System.out.println(boar1);
        System.out.println(horse1);

        for (int i=1; i<=10; i++) {
            wolf1.move();
            boar1.move();
            horse1.move();
            System.out.println(wolf1);
            System.out.println(boar1);
            System.out.println(horse1);
        }

    }

    public static void printCells (Island myIsland){
        for (IslandCell[] xxx : myIsland.myMysteryIsland) {
            for (IslandCell cell : xxx){
                System.out.println(cell);
            }
        }
    }

    public static IslandCell randomCell(){
        int x = ThreadLocalRandom.current().nextInt(0, myIsland.getLengthX());
        int y = ThreadLocalRandom.current().nextInt(0, myIsland.getLengthY());
        return myIsland.myMysteryIsland[y][x];
    }


}
