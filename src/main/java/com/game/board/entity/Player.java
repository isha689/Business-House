package main.java.com.game.board.entity;

import main.java.com.game.board.box.Hotel.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
    private final int USER_MONEY = 1000;
    int playerID;
    int position;
    List<Hotel> assets;

    public Player(int id){
        this.playerID = id;
        this.position = -1;
        this.money = USER_MONEY;
        this.assets = new ArrayList<>();
    }

    @Override
    public boolean deductMoney(int amount){
        boolean canDeduct = super.deductMoney(amount);
        if(!canDeduct){
            System.out.println("Player " + this.playerID + " has no enough money. Removing Player "+ this.playerID + " from the game.");
        }
        return canDeduct;
    }

    public void setPosition(int pos){
        this.position = pos;
    }

    public int getPosition(){
        return this.position;
    }

    public void buyHotel(Hotel hotel){
        this.assets.add(hotel);
    }

    public int getId() {
        return this.playerID;
    }

    public int getAssetsValue(){
        int assetsWorth = 0;
        for(Hotel h: this.assets){
            assetsWorth+=h.getValue();
        }
        return assetsWorth;
    }
}
