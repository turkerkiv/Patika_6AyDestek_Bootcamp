package Week4.Adventure_Game;

public class Place {
    String name;
    int ID;

    Place(String name, int ID)
    {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }
}
