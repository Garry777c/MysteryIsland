package General;

import java.util.HashMap;
import java.util.Map;

public class AnimalTable {

    private static AnimalTable animalTable = null;
    protected static String[] animalList = {
            "Wolf", "Boa", "Fox", "Bear", "Eagle",
            "Horse", "Deer", "Rabbit", "Mouse", "Goat", "Sheep", "Boar", "Bull", "Duck", "Caterpillar", "Plant"
    };

    protected Map<String, Map<String, Integer>> table = new HashMap<>();

    protected HashMap<String, Integer> wolfTable = new HashMap<String, Integer>(){{
            put ("Horse", 10); put ("Deer", 15); put ("Rabbit", 60); put ("Mouse", 80);
            put ("Goat", 60); put ("Sheep", 70); put ("Boar", 15); put ("Bull", 10);
            put ("Duck", 10);
        }};

    public static AnimalTable getInstance() {
        if (animalTable == null) {
            animalTable = new AnimalTable();

            animalTable.table.put("Wolf", animalTable.wolfTable);

        }
        return animalTable;
    }


    public int returnPossibility (String whoEats, String whoEaten){

        int value = animalTable.table.get(whoEats).get(whoEaten);

        return value;
    }



}
