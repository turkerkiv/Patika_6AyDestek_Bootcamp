package Week4.Adventure_Game;

public class GameManager {
    private Player player;
    private Place currentPlace;

    public static void main(String[] args) {

    }

    void startBattle(Player player, Monster monster)
    {
        System.out.println("Battle started!");
        while(player.getHealth() > 0)
        {
            System.out.println("Player's turn: ");
            player.attack(monster);
            //todo maybe add some small delaying here

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
