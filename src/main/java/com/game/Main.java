package main.java.com.game;

public class Main {

    public static void main(String[] args) {

        int noOfPlayers = 3;
        int noOfCells = 10;
        String cellInfo = "J,H,L,H,E,L,H,L,H,J";
        int[][] diceOut = new int[][]{{2,2,1},{4,2,3},{4,1,3},{2,2,7},{4,7,2},{4,4,2},{2,2,2}};

        Game g = new Game(noOfPlayers,noOfCells,cellInfo);
        g.play(diceOut);

    }
}
