package Week5.PatikaStore;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PatikaStore patikaStore = new PatikaStore();
        patikaStore.addBrand("Samsung");
        patikaStore.addBrand("Lenovo");
        patikaStore.addBrand("Apple");
        patikaStore.addBrand("Huawei");
        patikaStore.addBrand("Casper");
        patikaStore.addBrand("Asus");
        patikaStore.addBrand("HP");
        patikaStore.addBrand("Xiaomi");
        patikaStore.addBrand("Monster");

        patikaStore.addItem(new MobilePhone(patikaStore.getBrand("Samsung"), "S10", 1000, 0, 100, 6000, "Red", 6, 128, 6.13));
        patikaStore.addItem(new MobilePhone(patikaStore.getBrand("Samsung"), "S15", 1500, 0, 100, 8000, "Red", 8, 128, 6));
        patikaStore.addItem(new Notebook(patikaStore.getBrand("Samsung"), "Sambook", 606, 0, 100, 12, 512, 15.1));
        patikaStore.addItem(new Notebook(patikaStore.getBrand("Lenovo"), "Legion", 134, 0, 100, 16, 1024, 21.5));
        patikaStore.addItem(new MobilePhone(patikaStore.getBrand("Apple"), "Iphone 17", 2000, 0, 100, 3500, "Blue", 8, 64, 5.75));
        patikaStore.addItem(new Notebook(patikaStore.getBrand("Apple"), "Mac", 15000, 0, 100, 20, 512, 13.2));
        patikaStore.addItem(new MobilePhone(patikaStore.getBrand("Huawei"), "Huaphone", 400, 0, 100, 6000, "Magenta", 6, 128, 7.8));
        patikaStore.addItem(new Notebook(patikaStore.getBrand("Casper"), "Warrior", 5000, 0, 100, 6, 512, 16));
        patikaStore.addItem(new MobilePhone(patikaStore.getBrand("Asus"), "Zenphone", 1000, 0, 100, 6000, "Yellow", 6, 128, 4.13));
        patikaStore.addItem(new Notebook(patikaStore.getBrand("HP"), "Pavilion", 1000, 0, 100, 60, 1024, 17.4));
        patikaStore.addItem(new MobilePhone(patikaStore.getBrand("Xiaomi"), "Redmi", 100, 0, 100, 11000, "Orange", 16, 512, 8.13));
        patikaStore.addItem(new Notebook(patikaStore.getBrand("Monster"), "Monster", 1040, 0, 100, 12, 512, 16));

        System.out.println("PatikaStore product management panel");
        Scanner sc = new Scanner(System.in);

        while (true) {
            int choice = printMenu(sc);
            handleChoice(choice, patikaStore, sc);
        }
    }

    static int printMenu(Scanner sc) {
        System.out.println();
        System.out.println("1 - List notebooks");
        System.out.println("2 - List mobile phones");
        System.out.println("3 - List all items");
        System.out.println("4 - Add item");
        System.out.println("5 - Delete item");
        System.out.println("6 - List brands");
        System.out.println("7 - Order Items");
        System.out.println("0 - Exit");
        System.out.println();

        return sc.nextInt();
    }

    static void handleChoice(int choice, PatikaStore patikaStore, Scanner sc) {
        switch (choice) {
            case 0 -> System.exit(0);
            case 1 -> {
                List<Item> notebooks = patikaStore.getItemsList(Notebook.class);
                // Table header
                System.out.format("| %-10s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s%n", "ID", "Name", "Price", "Brand", "Storage", "Screen Size", "Ram");
                System.out.println("-----------------------------------------------------------------------------------------------------------");
                for (Item i : notebooks) {
                    Notebook n = (Notebook) i;
                    // Table data
                    System.out.format("| %-10s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s%n", n.getId(), n.getName(), n.getPrice(), n.getBrand().getName(), n.getStorage(), n.getScreenSize(), n.getRam());
                }
            }
            case 2 -> {
                List<Item> phones = patikaStore.getItemsList(MobilePhone.class);
                // Table header
                System.out.format("| %-10s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s%n", "ID", "Name", "Price", "Brand", "Storage", "Screen Size", "Ram", "Battery", "Color");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
                for (Item i : phones) {
                    MobilePhone m = (MobilePhone) i;
                    // Table data
                    System.out.format("| %-10s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-10s%n", m.getId(), m.getName(), m.getPrice(), m.getBrand().getName(), m.getStorage(), m.getScreenSize(), m.getRam(), m.getBattery(), m.getColor());
                }
            }
            case 3 -> {
                printAllItems(patikaStore.getItemsList(Item.class));
            }
            case 4 -> {
                //could write a method that finds unique classes but for now
                System.out.println("Choose type of item: \n1- Notebook\n2- Mobile Phone");

                int type = sc.nextInt();
                System.out.println("Enter brand's name: ");
                String brandName = sc.next();
                patikaStore.addBrand(brandName);
                System.out.println("Enter item's name: ");
                String itemName = sc.next();
                System.out.println("Enter item's price");
                int price = sc.nextInt();
                System.out.println("Enter stock: ");
                int stock = sc.nextInt();
                System.out.println("Enter ram: ");
                int ram = sc.nextInt();
                System.out.println("Enter storage: ");
                int storage = sc.nextInt();
                System.out.println("Enter screen size: ");
                double screenSize = sc.nextDouble();
                if (type == 1) {
                    patikaStore.addItem(new Notebook(patikaStore.getBrand(brandName), itemName, price, 0, stock, ram, storage, screenSize));
                } else {
                    System.out.println("Enter battery: ");
                    int battery = sc.nextInt();

                    System.out.println("Enter color: ");
                    String color = sc.next();

                    patikaStore.addItem(new MobilePhone(patikaStore.getBrand(brandName), itemName, price, 0, stock, battery, color, ram, storage, screenSize));
                }
                System.out.println("Successfully added.");
            }
            case 5 -> {
                System.out.print("Enter item ID: ");
                int id = sc.nextInt();
                patikaStore.deleteItem(id);
            }
            case 6 -> {
                List<Brand> brands = patikaStore.getBrandsList();
                System.out.println("Our Brands \n------------");
                for (Brand b : brands) {
                    System.out.println("- " + b.getName());
                }
            }
            case 7 -> {
                printAllItems(patikaStore.getItemsList(Item.class));
                System.out.println("Choose column to order according to that column: (1, 2, 3, 4)");
                int order = sc.nextInt();
                List<Item> sorted = patikaStore.orderItems(order);
                printAllItems(sorted);
            }
        }
    }

    static void printAllItems(List<Item> items)
    {
        // Table header
        System.out.format("| %-10s | %-15s | %-15s | %-10s%n", "ID", "Name", "Price", "Brand");
        System.out.println("-----------------------------------------------------------");
        for (Item i : items) {
            // Table data
            System.out.format("| %-10s | %-15s | %-15s | %-10s%n", i.getId(), i.getName(), i.getPrice(), i.getBrand().getName());
        }
    }
}
