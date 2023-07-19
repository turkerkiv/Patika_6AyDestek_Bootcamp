package Week4.Adventure_Game;

public class Player extends LivingCreature{
    PlayerInventory playerInventory;

    Player(String name, int ID, int health, int money) {
        super(name, ID, health, money);
        playerInventory = new PlayerInventory();
    }

    @Override
    public void attack()
    {
        //TODO
    }

    public void takeItem(Item item)
    {
        //TODO
    }
}
