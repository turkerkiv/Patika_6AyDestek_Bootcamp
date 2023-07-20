package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;

public class Shop extends SafePlace{
    private final List<Item> items;

    Shop(String name, int ID) {
        super(name, ID);
        items = new ArrayList<>();
        fillShopStocks();
    }

    private void fillShopStocks()
    {
        items.add(new Armor("Light", 1, 15, 1));
        items.add(new Armor("Medium", 2, 25, 3));
        items.add(new Armor("Heavy", 3, 40, 5));

        items.add(new Weapon("Sword", 4, 25, 2));
        items.add(new Weapon("Gun", 5, 35, 3));
        items.add(new Weapon("Rifle", 6, 45, 7));
    }

    public void buyItem(Player player, int itemID)
    {
        //TODO give player default armor and weapon
        for(Item i : items)
        {
            if(i.getID() == itemID)
            {
                if(player.setMoney(-i.getPrice()))
                {
                    player.takeItem(i);
                }
                else
                {
                    System.out.println("Not enough money!");
                }
            }

        }
    }
}
