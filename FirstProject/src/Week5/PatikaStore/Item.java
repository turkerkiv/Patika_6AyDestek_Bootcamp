package Week5.PatikaStore;

public class Item {
    private int id;
    private int price;
    private int discountRate;
    private int stock;
    private String name;
    private Brand brand;

    Item(Brand brand, String name, int price, int discountRate, int stock) {
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int getStock() {
        return stock;
    }
}
