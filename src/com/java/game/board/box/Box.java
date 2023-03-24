package com.java.game.board.box;

import com.java.game.board.Bank;
import com.java.game.board.Player;

import java.util.Queue;

public class Box {
    protected int value;

    public Box(){
        value = 0;
    }

    public void move(Player player, Bank bank, Queue<Player> playerQueue){
        playerQueue.add(player);
        return;
    }

}
