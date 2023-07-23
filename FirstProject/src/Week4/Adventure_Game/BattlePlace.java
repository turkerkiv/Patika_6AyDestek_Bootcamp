package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattlePlace extends Place{
    private final Item rewardItem;
    private final List<Monster> monsters;

    BattlePlace(String name, int ID, Item rewardItem, Monster monster) {
        super(name, ID);
        this.rewardItem = rewardItem;
        monsters = new ArrayList<Monster>();
        spawnMonsters(monster);
    }

    public void spawnMonsters(Monster monster)
    {
        int monsterCount = (int) (Math.random() * 2) + 2;
        for(int i = 0; i < monsterCount; i++)
        {
            monsters.add(new Monster(monster.getName(), monster.getID(), monster.getHealth(), monster.getMoney(), monster.getDamage()));
        }
    }

    public Monster getRandomMonster()
    {
        int randomIndex = (int) (Math.random() * (monsters.size() - 1));
        Monster monsterToReturn = monsters.get(randomIndex);
        monsters.remove(randomIndex);
        return monsterToReturn;
    }
}
