package main.java.com.game.board.box.Hotel;

import main.java.com.game.board.Bank;
import main.java.com.game.board.Player;
import main.java.com.game.board.box.Box;

import java.util.Queue;

public class Hotel extends Box {
    private final int SILVER_PRICE = 200;
    private final int GOLD_PRICE = 300;
    private final int PLATINUM_PRICE = 500;
    private final int SILVER_RENT = 50;
    private final int GOLD_RENT = 150;
    private final int PLATINUM_RENT = 300;

    int rent;
    public static int id=0;
    public boolean isUpgradable;
    HotelType hotelType;
    Player owner;

    public Hotel(){
        owner = null;
        hotelType = HotelType.SILVER;
        isUpgradable = true;
        value = SILVER_PRICE;
        rent = SILVER_RENT;
        id++;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public void move(Player player, Bank bank, Queue<Player> playerQueue){
        if(this.owner==null){
            buyHotel(player,bank);
        }
        else if(this.owner.equals(player)){
            upgrade(player,bank);
        }
        else{
            if(!payRent(player)){
                return;
            }
        }
        playerQueue.add(player);
    }

    private void buyHotel(Player player, Bank bank){
        if(player.getMoney()<this.value) return;
        this.owner = player;
        player.buyHotel(this);
        player.deductMoney(this.value);
        bank.addMoney(this.value);
    }
    private boolean payRent(Player player){
        if(!player.deductMoney(this.rent)){
            owner.addMoney(player.getMoney());
            player.deductMoney(player.getMoney());
            return false;
        }
        owner.addMoney(this.rent);
        return true;
    }

    private void upgrade(Player player, Bank bank){
        if(!this.isUpgradable) return;

        int amountToBePaid = upgradingAmount();
        if(player.getMoney()<amountToBePaid) return;
        player.deductMoney(amountToBePaid);
        bank.addMoney(amountToBePaid);
        upgrade();
    }

    private void upgrade(){
        if(this.hotelType.equals(HotelType.SILVER)){
            this.hotelType = HotelType.GOLD;
            this.rent = GOLD_RENT;
            this.value = GOLD_PRICE;
        }
        else{
            this.hotelType = HotelType.PLATINUM;
            this.rent = PLATINUM_RENT;
            this.value = PLATINUM_PRICE;
            this.isUpgradable = false;
        }
    }

    private int upgradingAmount(){
        if(this.hotelType.equals(HotelType.SILVER)){
            return GOLD_PRICE - SILVER_PRICE;
        }

        return PLATINUM_PRICE - GOLD_PRICE;
    }
}
