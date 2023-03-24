package main.java.com.game.board.box;

import main.java.com.game.board.entity.Bank;
import main.java.com.game.board.entity.Player;

import java.util.Queue;

public interface Box {
    void move(Player player, Bank bank, Queue<Player> playerQueue);
}
