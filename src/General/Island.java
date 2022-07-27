package General;

//class Island - singleton - one instance of Island
public class Island {
    private static Island instance = null;

    //island size X x Y
    private int lengthX = 8;
    private int lengthY = 8;


    IslandCell [][] myMysteryIsland = new IslandCell[lengthY][lengthX]; //locations (cells) number

    public static Island getInstance() {
        if (instance == null) {
            instance = new Island();

            for (int y=0; y < instance.myMysteryIsland.length; y++){ //filling array with Cell objects
                for (int x=0; x<instance.myMysteryIsland[y].length; x++) {
                    instance.myMysteryIsland[y][x] = new IslandCell(x, y);
                }
            }

        }
        return instance;
    }


    //getters - setters
    public int getLengthX() {
        return lengthX;
    }

    public void setLengthX(int lengthX) {
        this.lengthX = lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public void setLengthY(int lengthY) {
        this.lengthY = lengthY;
    }

    public IslandCell[][] getMyMysteryIsland() {
        return myMysteryIsland;
    }

}
