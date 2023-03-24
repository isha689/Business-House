package main.java.com.game.board.box.Hotel;

import main.java.com.game.board.entity.Bank;
import main.java.com.game.board.entity.Player;

public interface IHotel {

    boolean payRent(Player player);
    void buyHotel(Player player, Bank bank);
    void upgrade(Player player, Bank bank);
}
