package Week5.PatikaStore;

public class MobilePhone extends Item {
    private int battery;
    private String color;
    private int ram;
    private int storage;
    private double screenSize;

    MobilePhone(Brand brand, String name, int price, int discountRate, int stock, int battery, String color, int ram, int storage, double screenSize) {
        super(brand, name, price, discountRate, stock);
        this.battery = battery;
        this.color = color;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getBattery() {
        return battery;
    }

    public String getColor() {
        return color;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public double getScreenSize() {
        return screenSize;
    }
}
