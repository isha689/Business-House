package com.java.game.board;

public class Bank {
    final int BANK_MONEY = 5000;
    int money;

    public Bank(){
        this.money = BANK_MONEY;
    }

    public int getMoney(){
        return this.money;
    }

    public boolean deductMoney(int amount){
        if(amount>this.money) {
            System.out.println("Bank has no enough money. Ending the game !!");
            return false;
        }
        this.money-=amount;
        return true;
    }

    public void addMoney(int amount){
        this.money+=amount;
    }
}
