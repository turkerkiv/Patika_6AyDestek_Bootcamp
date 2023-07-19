package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;

public class BattlePlace extends Place{
    Item rewardItem;
    List<Monster> monsters;

    BattlePlace(String name, int ID, Item rewardItem, Monster monster) {
        super(name, ID);
        this.rewardItem = rewardItem;
        monsters = new ArrayList<Monster>();
        spawnMonsters(monster);
    }

    public void spawnMonsters(Monster monster)
    {
        //TODO
    }
}
