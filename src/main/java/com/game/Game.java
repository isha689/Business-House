package main.java.com.game;

import main.java.com.game.board.Board;
import main.java.com.game.board.entity.Player;
import main.java.com.game.board.box.Box;
import javafx.util.Pair;

import java.util.PriorityQueue;

public class Game {
    final int noOfChances = 7;
    Board board;
    int noOfCells;

    public Game(int noOfPlayers, int noOfCells, String cellInfo){
        board = new Board();
        this.noOfCells = noOfCells;
        board.initialisePlayers(noOfPlayers);
        board.initializeBoard(noOfCells,cellInfo);
    }

    public int[][] play(int[][] diceOutput){

        for(int i=0;i<diceOutput.length;i++){
            int size = board.players.size();
            if(size<=1) break;
            while(size--!=0) {
                if (board.players.size() <= 1) {
                    return endGame();
                }
                Player currPlayer = board.players.poll();
                int diceOut = diceOutput[i][currPlayer.getId()];
                currPlayer.setPosition((currPlayer.getPosition() + diceOut) % noOfCells);
                Box currBox = board.gameBoard[currPlayer.getPosition()];
                currBox.move(currPlayer, board.bank, board.players);
            }
        }
        return endGame();
    }

    private int[][] endGame(){
        PriorityQueue<Pair<Integer,Player>> maxHeap = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        for(int i=0;i<board.playerList.size();i++){
            Player player = board.playerList.get(i);
            maxHeap.add(new Pair<>(player.getMoney()+player.getAssetsValue(),player));
        }
        int[][] gameResult = new int[maxHeap.size()+1][3];
        int i=0;
        while(!maxHeap.isEmpty()){
            Pair<Integer,Player> top = maxHeap.poll();
            gameResult[i++]= new int[]{top.getValue().getId() + 1, top.getValue().getAssetsValue(), top.getValue().getMoney()};
//            System.out.println("Player "+ (top.getValue().getId()+1) + " => Assets Worth => " + top.getValue().getAssetsValue() + " => " + top.getValue().getMoney());
        }
//        System.out.println("Bank => " + board.bank.getMoney());
        gameResult[i]= new int[]{-1,0,board.bank.getMoney()};
        return gameResult;
    }
}
