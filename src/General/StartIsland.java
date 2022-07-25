package General;


import Animals.LifeElement;

import java.util.*;
import java.util.concurrent.*;

public class StartIsland {

    public static Island myIsland = Island.getInstance(); //create island instance
    public static volatile HashSet<LifeElement> animalList = new HashSet<>();
    public static volatile ArrayList<LifeElement> animalsOnCell = new ArrayList<>();
    public static LifeElementFactory lifeElementFactory = new LifeElementFactory();
    public static volatile int counter = 0;
    public static ExecutorService executorService = new ScheduledThreadPoolExecutor(5);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //create possibility table
        AnimalTable.getInstance();

        //start LifeElement factory
        for (int s=0; s<30; s++){
            animalList.add(lifeElementFactory.getAnimalByType(randomAnimalTypeEnum()));
        }

//        animalList.add(lifeElementFactory.getAnimalByType(AnimalType.WOLF));
//        animalList.add(lifeElementFactory.getAnimalByType(AnimalType.HORSE));
//        animalList.add(lifeElementFactory.getAnimalByType(AnimalType.BOAR));
//        animalList.add(lifeElementFactory.getAnimalByType(AnimalType.PLANT));



        animalList.forEach(System.out::println);
        System.out.println("Animals number: "+animalList.size());

        for (int run = 0; run <6; run++){
            oneCycle();
            System.out.println("End of cycle_____________________________");
        }



        executorService.shutdown();

        animalList.forEach(System.out::println);
        System.out.println("Animals number: "+animalList.size());

    }


    public static synchronized void oneCycle() throws InterruptedException {
        for (int i = 0; i < myIsland.myMysteryIsland.length; i++) {
            for (int j = 0; j < myIsland.myMysteryIsland[i].length; j++) {
                System.out.println("cell: " + myIsland.myMysteryIsland[i][j]);

                //remove all eaten LifeElements from the HashSet
                animalList.stream().filter(lifeElement -> !lifeElement.isAlive())
                        .forEach(lifeElement -> System.out.println(lifeElement.getClass().getSimpleName() + " dead"));
                animalList.removeIf(lifeElement -> !lifeElement.isAlive());

                //filling cell with animal based on their coordinates
                for (LifeElement animal : animalList) {
                    if (animal.getLocation().equals(myIsland.myMysteryIsland[i][j])) {
                        animalsOnCell.add(animal);
                    }
                }

                if (!animalsOnCell.isEmpty()) {
                    System.out.println("in cell: " + animalsOnCell);
                } else {
                    System.out.println("no animal in cell");
                }

                //run Threads from animalsOnCell here before move to another cell
                executorService.invokeAll(animalsOnCell, 100, TimeUnit.MILLISECONDS);
                animalsOnCell.clear();
            }
        }
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

    //random AnimalType enum
    public static AnimalType randomAnimalTypeEnum(){
        int x = AnimalType.values().length;
        int random = ThreadLocalRandom.current().nextInt(0, x);
        return AnimalType.values()[random];
    }


}
