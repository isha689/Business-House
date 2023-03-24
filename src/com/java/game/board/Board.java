package com.java.game.board;

import com.java.game.board.box.Box;
import com.java.game.board.box.Hotel.Hotel;
import com.java.game.board.box.Jail;
import com.java.game.board.box.Lottery;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Board {
    public Queue<Player> players;
    public ArrayList<Player> playerList;
    public Box[] gameBoard;
    public Bank bank;

    public Board(){
        playerList = new ArrayList<>();
        players = new LinkedList<>();
        bank = new Bank();
    }

    public void initialisePlayers(int n){
        if(n<2){
            throw new Error("At least two players should play.");
        }
        for(int i=0;i<n;i++){
            Player p = new Player(i);
            players.add(p);
            playerList.add(p);
        }
    }

    public void initializeBoard(int noOfCells, String inputCells){
        gameBoard = new Box[noOfCells];
        String[] cells = inputCells.split(",");
        if(cells.length!=noOfCells){
            throw new Error("Invalid input cells. Please enter exactly "+noOfCells+ " cells.");
        }
        for(int i=0;i<noOfCells;i++){

            if(cells[i].equals("J")){
                gameBoard[i] = new Jail();
            }
            else if(cells[i].equals("L")){
                gameBoard[i] = new Lottery();
            }
            else if(cells[i].equals("E")){
                gameBoard[i] = new Box();
            }
            else if(cells[i].equals("H")){
                gameBoard[i] = new Hotel();
            }
            else{
                throw new Error("Invalid Cell Type. Enter only J, E, H or L");
            }
        }
    }
}
