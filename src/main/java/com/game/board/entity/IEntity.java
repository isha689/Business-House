package main.java.com.game.board.entity;

public interface IEntity {

    void addMoney(int amount);
    boolean deductMoney(int amount);
    int getMoney();
}
