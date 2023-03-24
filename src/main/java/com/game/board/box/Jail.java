package main.java.com.game.board.box;

import main.java.com.game.board.Bank;
import main.java.com.game.board.Player;

import java.util.Queue;

public class Jail extends Box{

    private final int JAIL_FINE = 150;

    public Jail(){
        value = JAIL_FINE;
    }

    @Override
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
