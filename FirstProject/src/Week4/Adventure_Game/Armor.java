package Week4.Adventure_Game;

public class Armor extends Item{
    private int defenceValue;

    Armor(String name, int ID, int price, int defenceValue) {
        super(name, ID, price);
        this.defenceValue = defenceValue;
    }

    public int getDefenceValue() {
        return defenceValue;
    }
}