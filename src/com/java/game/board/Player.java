package com.java.game.board;

import com.java.game.board.box.Hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Player {
    static int USER_MONEY = 1000;
    int playerID;
    int position;
    int money;
    boolean hasWon;
    List<Hotel> assets;

    public Player(int id){
        this.playerID = id;
        position = -1;
        hasWon = false;
        money = USER_MONEY;
        assets = new ArrayList<>();
    }

    public int getMoney(){
        return this.money;
    }
    public void addMoney(int amt){
        money+=amt;
    }
    public boolean deductMoney(int amt){
        if(amt>this.money) {
            System.out.println("Player " + this.playerID + " has no enough money. Removing Player "+ this.playerID + " from the game.");
            return false;
        }
        money-=amt;
        return true;
    }
    public void setPosition(int pos){
        position = pos;
    }
    public int getPosition(){
        return position;
    }

    public void buyHotel(Hotel hotel){
        assets.add(hotel);
    }

    public int getId() {
        return playerID;
    }

    public int getAssetsValue(){
        int assetsWorth = 0;
        for(Hotel h: this.assets){
            assetsWorth+=h.getValue();
        }
        return assetsWorth;
    }
}
