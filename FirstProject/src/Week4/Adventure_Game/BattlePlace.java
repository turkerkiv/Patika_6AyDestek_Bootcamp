package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;

public class BattlePlace extends Place{
    private Item rewardItem;
    private List<Monster> monsters;

    BattlePlace(String name, int ID, Item rewardItem, Monster monster) {
        super(name, ID);
        this.rewardItem = rewardItem;
        monsters = new ArrayList<Monster>();
        spawnMonsters(monster);
    }

    public void spawnMonsters(Monster monster)
    {
        //int monsterCount = (int) (Math.random() * 3);
        //for(int i = 0; i < monsterCount; i++)
        //{
        //    monsters.add(new Monster(monster.getName(), monster.getID(), monster.getHealth(), monster.getMoney(), monster.getDamage()));
        //}
        //TODO
    }
}
