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
        items.add(new Armor("Light Armor", 1, 15, 1));
        items.add(new Armor("Medium Armor", 2, 25, 3));
        items.add(new Armor("Heavy Armor", 3, 40, 5));

        items.add(new Weapon("Sword", 4, 25, 2));
        items.add(new Weapon("Gun", 5, 35, 3));
        items.add(new Weapon("Rifle", 6, 45, 7));
    }

    public int listItems()
    {
        System.out.println();
        for(Item i : items)
        {
            System.out.println("(" + items.indexOf(i) + ") "+ i.getName() +" "+i.getPrice() + "$");
        }

        System.out.println("(Other Number) Go to home");
        return items.size();
    }

    public void buyItem(Player player, int choice)
    {
            Item i = items.get(choice);
            if(player.setMoney(-i.getPrice()))
                {
                    player.takeItem(i);
                    items.remove(i);
                    System.out.println(i.getName() + " added to inventory");
                }
            else
                {
                    System.out.println("Not enough money!");
                }
    }
}
