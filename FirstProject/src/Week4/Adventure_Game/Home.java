package Week4.Adventure_Game;

public class Home extends SafePlace{

    Home(String name, int ID) {
        super(name, ID);
    }

    public void healPlayer(Player player)
    {
        player.heal();
    }
}
