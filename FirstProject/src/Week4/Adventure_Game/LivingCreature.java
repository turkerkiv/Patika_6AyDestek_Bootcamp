package Week4.Adventure_Game;

public class LivingCreature {
    String name;
    int ID;
    int health;
    int money;

    LivingCreature(String name, int ID, int health, int money)
    {
        this.name = name;
        this.ID = ID;
        this.health = health;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public void attack()
    {
        //TODO
    }
}
