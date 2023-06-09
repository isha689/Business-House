package main.java.com.game.board.box;

import main.java.com.game.board.entity.Bank;
import main.java.com.game.board.entity.Player;

import java.util.Queue;

public class Lottery extends EmptyBox {

    private final int LOTTERY_AMOUNT = 200;
    private final int value;

    public Lottery(){
        this.value = LOTTERY_AMOUNT;
    }

    public void move(Player player, Bank bank, Queue<Player> playerQueue){

        if(!bank.deductMoney(this.value)){
            playerQueue.clear();
            return;
        }
        player.addMoney(this.value);
        playerQueue.add(player);
    }
}
