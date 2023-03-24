package main.java.com.game.board.entity;

public class Bank extends Entity{
    private final int BANK_MONEY = 5000;

    public Bank(){
        this.money = BANK_MONEY;
    }

    @Override
    public boolean deductMoney(int amount){
        boolean canDeduct = super.deductMoney(amount);
        if(!canDeduct){
            System.out.println("Bank has no enough money. Ending the game !!");
        }
        return canDeduct;
    }
}
