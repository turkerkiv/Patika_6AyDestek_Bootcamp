package Week5.PatikaStore;

public class Notebook extends Item {
    private int ram;
    private int storage;
    private double screenSize;

    Notebook(Brand brand, String name, int price, int discountRate, int stock, int ram, int storage, double screenSize) {
        super(brand, name, price, discountRate, stock);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getStorage() {
        return storage;
    }
}
