package General;

public class Island {
    private static Island instance = null;
    private int lengthX=3;
    private int lengthY=3;


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

//    public void setMyMysteryIsland(IslandCell[][] myMysteryIsland) {
//        this.myMysteryIsland = myMysteryIsland;
//    }
}
