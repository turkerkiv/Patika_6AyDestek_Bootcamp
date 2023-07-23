package Week4.Adventure_Game;

public class Player extends LivingCreature{
    private final PlayerInventory playerInventory;
    private final int charDamage;

    Player(String name, int ID, int health, int money, int charDamage) {
        super(name, ID, health, money);
        playerInventory = new PlayerInventory();
        this.charDamage = charDamage;
    }

    public void listCurrentAttributes()
    {
        System.out.println();
        System.out.println("Name: " + getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Money: " + getMoney());
        System.out.println("Attack: " + playerInventory.getCurrentWeapon().getDamage());
        System.out.println("Defence: " + playerInventory.getCurrentArmor().getDefenceValue());
        System.out.println();
    }

    public int getCharDamage()
    {
        return charDamage;
    }

    @Override
    public void attack(LivingCreature creature)
    {
        creature.takeDamage(playerInventory.getCurrentWeapon().getDamage() + charDamage);
    }

    @Override
    public void takeDamage(int damage)
    {
        int decreasedDamage = damage - playerInventory.getCurrentArmor().getDefenceValue();
        super.takeDamage(decreasedDamage);
    }

    public void takeItem(Item item)
    {
        if(item instanceof Armor)
        {
            playerInventory.setCurrentArmor((Armor) item);
        }else if(item instanceof Weapon) {
            playerInventory.setCurrentWeapon((Weapon) item);
        }
        else {
            playerInventory.addRewardItem(item);
        }
    }

    public boolean areItemsCompleted()
    {
        return playerInventory.getRewardCount() >= 3;
    }
}
