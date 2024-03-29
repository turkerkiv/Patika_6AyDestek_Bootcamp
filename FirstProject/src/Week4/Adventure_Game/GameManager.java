package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    private final List<Player> characters;
    private final Player player;
    private final List<Place> places;
    private Place currentPlace;

    GameManager() {
        //Battle places
        places = new ArrayList<>();
        places.add(new BattlePlace("Cave", 1, new Item("Food", 0, 0), new Monster("Zombie", 1, 10, 13, 5)));
        places.add(new BattlePlace("Jungle", 2, new Item("Firewood", 0, 0), new Monster("Vampire", 2, 14, 16, 7)));
        places.add(new BattlePlace("River", 3, new Item("Water", 0, 0), new Monster("Bear", 3, 20, 21, 9)));

        //safe places
        places.add(new Shop("Shop", 4));
        places.add(new Home("Base (Heal)", 5));

        //character choosing
        characters = new ArrayList<>();
        characters.add(new Player("Samurai", 1, 25, 55, 2));
        characters.add(new Player("Archer", 2, 22, 60, 4));
        characters.add(new Player("Chivalry", 3, 28, 45, 5));
        System.out.println("Please select a character:");
        for(Player p : characters)
        {
            System.out.println("("+ characters.indexOf(p) +") " + p.getName() + " --- health: " + p.getHealth() + " --- money: " + p.getMoney() + " --- character damage: " + p.getCharDamage());
        }
        Scanner inp = new Scanner(System.in);
        int choice = inp.nextInt();
        player = characters.get(choice);

        //giving default items to player
        ((Shop) places.get(3)).buyItem(player, 0);
        ((Shop) places.get(3)).buyItem(player, 2);

        player.listCurrentAttributes();
    }

    public boolean isGameFinished()
    {
        if(player.getHealth() <= 0 || player.areItemsCompleted())
        {
            System.out.println("Game is finished.");
            return true;
        }
        return false;
    }

    public void selectPlace(Scanner scn)
    {
        if(isGameFinished()) return;

        listPlaces();

        int choice = scn.nextInt();
        currentPlace = places.get(choice - 1);

        onPlaceChange(scn);
    }

    private void listPlaces()
    {
        System.out.println();
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
            if(((BattlePlace) currentPlace).isPlaceCompleted())
            {
                System.out.println("You already cleaned this place!");
                selectPlace(scn);
                return;
            }

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

        double chance = Math.random();
        LivingCreature firstStarter = chance > 0.5f ? player : rndMonster;
        LivingCreature secondStarter = firstStarter == player ? rndMonster : player;

        while(player.getHealth() > 0)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println();
            System.out.println(firstStarter.getName() +"'s turn: ");
            firstStarter.attack(secondStarter);
            System.out.println(secondStarter.getName()+"'s health: " + secondStarter.getHealth());
            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //handling monster's death
            if(rndMonster.getHealth() <= 0) {
                player.setMoney(rndMonster.getMoney());
                battlePlace.killMonster(rndMonster);

                Item reward = battlePlace.earnReward();
                if( reward != null) player.takeItem(reward);
                break;
            }

            System.out.println(secondStarter.getName()+"'s turn: ");
            secondStarter.attack(firstStarter);
            System.out.println(firstStarter.getName()+"'s health: " + firstStarter.getHealth());
        }
    }

    private void onSelectShop(Scanner scn, Shop shop)
    {
        System.out.println("Welcome to the shop, sir!");

        player.listCurrentAttributes();

        int itemCount = shop.listItems();

        int choice = scn.nextInt();

        if(choice >= itemCount) {
            selectPlace(scn);
            return;
        }

        shop.buyItem(player, choice);
    }
}
