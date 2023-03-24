package com.java.game.board.box;

import com.java.game.board.Bank;
import com.java.game.board.Player;

import java.util.Queue;

public class Lottery extends Box {

    private final int LOTTERY_AMOUNT = 200;

    public Lottery(){
        value = LOTTERY_AMOUNT;
    }

    @Override
    public void move(Player player, Bank bank, Queue<Player> playerQueue){

        if(!bank.deductMoney(this.value)){
            playerQueue.clear();
            return;
        }
        player.addMoney(this.value);
        playerQueue.add(player);
    }
}
