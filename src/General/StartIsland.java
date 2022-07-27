package General;


import Animals.LifeElement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class StartIsland {

    public static Island myIsland = Island.getInstance(); //create island instance
    public static volatile HashSet<LifeElement> animalList = new HashSet<>(); //main set of all animals/Plants
    public static volatile ArrayList<LifeElement> animalsOnCell = new ArrayList<>(); //list of animals/Plants for current cell
    public static LifeElementFactory lifeElementFactory = new LifeElementFactory(); //instance of Factory
    public static List <LifeElement> endOfCycle = new ArrayList<>();
    public static volatile int counter = 0;
    public static volatile int maxNewBorn = 0;
    public static volatile int cycles = 0;
    public static volatile int startAmountOfAnimal = 0;
    public static ExecutorService executorService = new ScheduledThreadPoolExecutor(5); //instance of Executor

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //create possibility table
        AnimalTable.getInstance();

        System.out.println("Welcome to the Mystery Island!\n" + "_____________________________\n"+"Island has a field 8x8\n"+"________________________" );

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter how many new Animals might be born (hit: 100...2000)...");
            maxNewBorn = Integer.parseInt(reader.readLine());

            System.out.println("Enter how many cycles the Island will be existing...");
            cycles = Integer.parseInt(reader.readLine());

            System.out.println("Enter how many animals you would like to start with...");
            startAmountOfAnimal = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }




        //start LifeElement factory - create Animals/Plants - more plants per cycle
        for (int s=0; s<startAmountOfAnimal; s++){
            animalList.add(lifeElementFactory.getAnimalByType(randomAnimalTypeEnum()));
            for (int w=0; w<10; w++) {//just adding many Plants to balance the Island
                animalList.add(lifeElementFactory.getAnimalByType(AnimalType.PLANT));
            }
        }

        animalList.forEach(System.out::println);
        System.out.println("Animals number: "+animalList.size());

        //run Island by curtain cycles
        for (int run = 0; run <cycles; run++){
            oneCycle();
        }

        executorService.shutdown();

        animalList.forEach(System.out::println);
        System.out.println("Animals number: "+animalList.size());

    }

    //one cycle method
    public static synchronized void oneCycle() throws InterruptedException {
        for (int i = 0; i < myIsland.myMysteryIsland.length; i++) {
            for (int j = 0; j < myIsland.myMysteryIsland[i].length; j++) {
                System.out.println("cell: " + myIsland.myMysteryIsland[i][j]);

                //remove all eaten LifeElements from the HashSet
                animalList.stream().filter(lifeElement -> !lifeElement.isAlive())
                        .filter(lifeElement -> !lifeElement.getClass().getSimpleName().equals("Plant"))
                        .forEach(lifeElement -> System.out.println(lifeElement.getClass().getSimpleName() + " dead"));
                animalList.removeIf(lifeElement -> !lifeElement.isAlive());

                //filling cell with animal based on their coordinates
                for (LifeElement animal : animalList) {
                    if (animal.getLocation().equals(myIsland.myMysteryIsland[i][j])) {
                        animalsOnCell.add(animal);
                    }
                }

                //how many on cell
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

    //set random cell for each object
    public static IslandCell randomCell(){
        int x = ThreadLocalRandom.current().nextInt(0, Island.getInstance().getLengthX());
        int y = ThreadLocalRandom.current().nextInt(0, Island.getInstance().getLengthY());
        return myIsland.myMysteryIsland[y][x];
    }

    //random AnimalType enum
    public static AnimalType randomAnimalTypeEnum(){
        int x = AnimalType.values().length;
        int random = ThreadLocalRandom.current().nextInt(0, x);
        return AnimalType.values()[random];
    }

}
