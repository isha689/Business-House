import com.java.game.Game;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestGame {

    @Test
    public void Test1() {
        int noOfPlayers = 3;
        int noOfCells = 10;
        String cellInfo = "J,H,L,H,E,L,H,L,H,J";
        int[][] diceOut = new int[][]{{2, 2, 1}, {4, 2, 3}, {4, 1, 3}, {2, 2, 7}, {4, 7, 2}, {4, 4, 2}, {2, 2, 2}};

        Game g = new Game(noOfPlayers, noOfCells, cellInfo);
        int[][] result = g.play(diceOut);

        int[][] expectedResult = new int[][]{{1, 500, 650}, {3, 200, 850}, {2, 300, 750}, {-1, 0, 5750}};
        assertEquals(expectedResult,result);
    }

    @Test
    public void Test2() {
        int noOfPlayers = 3;
        int noOfCells = 10;
        String cellInfo = "J,H,L,H,E,L,H,L,H,J";
        int[][] diceOut = new int[][]{{2, 2, 1}, {4, 4, 2}, {4, 4, 2}, {2, 2, 1}, {4, 4, 2}, {4, 4, 2}, {2, 2, 1}};

        Game g = new Game(noOfPlayers, noOfCells, cellInfo);
        int[][] result = g.play(diceOut);

        int[][] expectedResult = new int[][]{{1, 500, 1100}, {3, 0, 1150}, {2, 0, 600}, {-1, 0, 5150}};
        assertEquals(expectedResult, result);
    }

    @Test
    public void TestThrowsInvaildInputFormat() {
        int noOfPlayers = 3;
        int noOfCells = 10;
        String cellInfo = "J,S,L,H,E,L,H,L,H,J";
        int[][] diceOut = new int[][]{{2, 2, 1}, {4, 4, 2}, {4, 4, 2}, {2, 2, 1}, {4, 4, 2}, {4, 4, 2}, {2, 2, 1}};

        try {
            Game g = new Game(noOfPlayers, noOfCells, cellInfo);
            int[][] result = g.play(diceOut);
        } catch (Error e) {
            assertEquals("Invalid Cell Type. Enter only J, E, H or L", e.getMessage());
        }
    }

    @Test
    public void TestThrowsInvaildNoOfCells() {
        int noOfPlayers = 3;
        int noOfCells = 10;
        String cellInfo = "J,S,L,H,E,L,H,L";
        int[][] diceOut = new int[][]{{2, 2, 1}, {4, 4, 2}, {4, 4, 2}};

        try {
            Game g = new Game(noOfPlayers, noOfCells, cellInfo);
            int[][] result = g.play(diceOut);
        } catch (Error e) {
            assertEquals("Invalid input cells. Please enter exactly 10 cells.", e.getMessage());
        }
    }

    @Test
    public void TestThrowsInvaildNoOfPlayers() {
        int noOfPlayers = 1;
        int noOfCells = 10;
        String cellInfo = "J,H,L,H,E,L,H,L,H,J";
        int[][] diceOut = new int[][]{{2}, {4}};

        try {
            Game g = new Game(noOfPlayers, noOfCells, cellInfo);
            int[][] result = g.play(diceOut);
        } catch (Error e) {
            assertEquals("At least two players should play.", e.getMessage());
        }
    }
}
