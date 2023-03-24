package main.java.com.game.board.box;

import main.java.com.game.board.entity.Bank;
import main.java.com.game.board.entity.Player;

import java.util.Queue;

public class EmptyBox implements Box{

    private final int value;

    public EmptyBox(){
        this.value = 0;
    }

    public void move(Player player, Bank bank, Queue<Player> playerQueue){
        playerQueue.add(player);
        return;
    }

}
