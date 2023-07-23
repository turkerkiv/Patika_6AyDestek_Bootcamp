package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private final Player player;
    private final List<Place> places;
    private Place currentPlace;

    GameManager() {
        //Battle places
        places = new ArrayList<>();
        places.add(new BattlePlace("Cave", 1, new Item("Food", 0, 0), new Monster("Zombie", 1, 10, 4, 3)));
        places.add(new BattlePlace("Jungle", 2, new Item("Firewood", 0, 0), new Monster("Vampire", 2, 14, 7, 4)));
        places.add(new BattlePlace("River", 3, new Item("Water", 0, 0), new Monster("Bear", 3, 20, 12, 7)));

        //safe places
        places.add(new Shop("Shop", 4));
        places.add(new Home("Base", 5));

        player = new Player("Samurai", 1, 21, 150, 5);

        //giving default items to player
        ((Shop) places.get(3)).buyItem(player, 1);
        ((Shop) places.get(3)).buyItem(player, 4);

        player.listCurrentAttributes();

        //TODO bug in getting rnd monster
        //TODO bug in item's price
    }

    public boolean isGameFinished()
    {
        return player.getHealth() <= 0 || player.areItemsCompleted();
    }

    public void selectPlace(Scanner scn)
    {
        listPlaces();

        int choice = scn.nextInt();
        currentPlace = places.get(choice - 1);

        onPlaceChange(scn);
    }

    private void listPlaces()
    {
        System.out.println("Select a place to go.");
        for(Place p : places)
        {
            System.out.println("(" + p.getID() + ") "+ p.getName());
        }
    }

    private void onPlaceChange(Scanner scn)
    {
        if(currentPlace instanceof BattlePlace)
        {
            onSelectBattlePlace((BattlePlace) currentPlace);
            selectPlace(scn);
        }
        else if(currentPlace instanceof Home)
        {
            System.out.println("You get healed.");
            player.heal();
            selectPlace(scn);
        }
        else {
            onSelectShop(scn, (Shop) currentPlace);
        }
    }

    private void onSelectBattlePlace(BattlePlace battlePlace)
    {
        Monster rndMonster = battlePlace.getRandomMonster();

        System.out.println("Battle started!");

        while(player.getHealth() > 0)
        {
            System.out.println();

            System.out.println("Player's turn: ");
            player.attack(rndMonster);
            System.out.println("Monster's health: " + rndMonster.getHealth());

            System.out.println();

            //todo maybe add some small delaying her
            //todo taking monsters money when died

            if(rndMonster.getHealth() <= 0) break;

            System.out.println("Monster's turn: ");
            rndMonster.attack(player);
            System.out.println("Player's health: " + player.getHealth());
        }
    }

    private void onSelectShop(Scanner scn, Shop shop)
    {
        System.out.println("Welcome to the shop, sir!");
        int itemCount = shop.listItems();

        int choice = scn.nextInt();

        if(choice > itemCount) {
            selectPlace(scn);
            return;
        }

        shop.buyItem(player, choice);
    }
}
