package Week5.PatikaStore;

public class Brand {
    private int id;
    private String name;

    Brand(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
