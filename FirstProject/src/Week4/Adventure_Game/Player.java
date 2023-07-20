package Week4.Adventure_Game;

public class Player extends LivingCreature{
    private final PlayerInventory playerInventory;

    Player(String name, int ID, int health, int money) {
        super(name, ID, health, money);
        playerInventory = new PlayerInventory();
        //todo implement character choosing
    }

    @Override
    public void attack(LivingCreature creature)
    {
        creature.takeDamage(playerInventory.getCurrentWeapon().getDamage());
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
}
