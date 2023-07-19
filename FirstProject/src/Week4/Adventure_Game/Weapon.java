package Week4.Adventure_Game;

public class Weapon extends Item{
    private int damage;

    Weapon(String name, int ID, int price, int damage) {
        super(name, ID, price);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
