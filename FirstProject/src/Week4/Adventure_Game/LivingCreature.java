package Week4.Adventure_Game;

public abstract class LivingCreature {
    private String name;
    private int ID;
    private int health;
    private int money;

    private int defaultHealth;
    private boolean isDead;

    LivingCreature(String name, int ID, int health, int money)
    {
        this.name = name;
        this.ID = ID;
        this.health = health;
        defaultHealth = health;
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

    public void heal(){health = defaultHealth;}

    public int getMoney() {
        return money;
    }

    public boolean setMoney(int amount){
        if((money += amount) <= 0)
        {
            return false;
        }
        money += amount;
        return true;
    }

    public void takeDamage(int damage)
    {
        if(isDead) return;
        health -= damage;
        isDead = health <= 0;
    }

    public abstract void attack(LivingCreature creature);
}
