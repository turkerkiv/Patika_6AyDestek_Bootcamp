package Week4.Adventure_Game;

public class Monster extends LivingCreature{
    private int damage;

    Monster(String name, int ID, int health, int money, int damage) {
        super(name, ID, health, money);
        this.damage = damage;
    }

    public int getDamage()
    {
        return damage;
    }

    @Override
    public void attack()
    {
        //TODO
    }
}
