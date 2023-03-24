package main.java.com.game.board.box;

import main.java.com.game.board.entity.Bank;
import main.java.com.game.board.entity.Player;

import java.util.Queue;

public class Jail implements Box {

    private final int JAIL_FINE = 150;
    private final int value;

    public Jail(){
        this.value = JAIL_FINE;
    }

    public void move(Player player, Bank bank, Queue<Player> playerQueue){
        if(!player.deductMoney(this.value)){
            bank.addMoney(player.getMoney());
            player.deductMoney(player.getMoney());
            return;
        }
        bank.addMoney(this.value);
        playerQueue.add(player);
    }
}
