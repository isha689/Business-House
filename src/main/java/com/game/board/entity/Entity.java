package main.java.com.game.board.entity;

public abstract class Entity implements IEntity{
    protected int money;

    public int getMoney(){
        return this.money;
    }

    public boolean deductMoney(int amount){
        if(amount>this.money) {
            return false;
        }
        this.money-=amount;
        return true;
    }

    public void addMoney(int amount){
        this.money+=amount;
    }
}
