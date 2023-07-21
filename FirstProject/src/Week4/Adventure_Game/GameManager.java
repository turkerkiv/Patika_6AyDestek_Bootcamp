package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final Player player;
    private final List<BattlePlace> battlePlaces;
    private final Shop shop;
    private final Home home;
    private Place currentPlace;

    GameManager() {
        //Battle places
        battlePlaces = new ArrayList<>();
        battlePlaces.add(new BattlePlace("Cave", 1, new Item("Food", 0, 0), new Monster("Zombie", 1, 10, 4, 3)));
        battlePlaces.add(new BattlePlace("Jungle", 2, new Item("Firewood", 0, 0), new Monster("Vampire", 2, 14, 7, 4)));
        battlePlaces.add(new BattlePlace("River", 3, new Item("Water", 0, 0), new Monster("Bear", 3, 20, 12, 7)));

        shop = new Shop("Shop", 4);
        home = new Home("Home", 5);

        player = new Player("Samurai", 1, 21, 15, 5);
    }

    void startBattle(Player player, Monster monster)
    {
        System.out.println("Battle started!");
        while(player.getHealth() > 0)
        {
            System.out.println("Player's turn: ");
            player.attack(monster);
            //todo maybe add some small delaying her

            if(monster.getHealth() <= 0) break;
            System.out.println("Monster's turn: ");
            monster.attack(player);
        }
    }

    void changePlace(Place newPlace)
    {
        if(newPlace instanceof Home) player.heal();
        currentPlace = newPlace;
    }
}
