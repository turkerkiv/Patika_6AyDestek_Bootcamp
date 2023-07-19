package Week4.Adventure_Game;

public class Item {
    String name;
    int ID;
    int price;

    Item(String name, int ID, int price)
    {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }
}
