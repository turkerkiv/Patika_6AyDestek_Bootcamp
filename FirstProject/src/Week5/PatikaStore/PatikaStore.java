package Week5.PatikaStore;

import java.util.*;

public class PatikaStore {

    private final Set<Brand> brands = new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    private final Set<Item> items = new TreeSet<>(new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    });

    public void addBrand(String name) {
        brands.add(new Brand(brands.size() + 1, name));
    }

    public void addItem(Item item) {
        item.setId(items.size() + 1);
        items.add(item);
    }

    public Brand getBrand(String brandName) {
        Brand brandToReturn = null;
        for (Brand b : brands) {
            if (b.getName().equals(brandName)) {
                brandToReturn = b;
            }
        }
        return brandToReturn;
    }

    public List<Brand> getBrandsList() {
        return new ArrayList<>(brands);
    }

    public <T extends Item> List<Item> getItemsList(Class<T> type) {
        if (type.equals(Item.class)) return new ArrayList<>(items);

        List<Item> listToReturn = new ArrayList<>();
        for (Item i : items) {
            if (i.getClass().equals(type)) {
                listToReturn.add(i);
            }
        }
        return listToReturn;
    }

    public void deleteItem(int id) {
        items.removeIf(i -> i.getId() == id);
    }

    public List<Item> orderItems(int selectedColumnIndex) {
        //filtering could be done by same way like choosing a column and entering a value like brands column is 4 and Samsung
        List<Item> sorted = new ArrayList<>(items);
        switch (selectedColumnIndex) {
            case 1 -> {
                sorted.sort(new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        return Integer.compare(o1.getId(), o2.getId());
                    }
                });
            }
            case 2 -> {
                sorted.sort(new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
            }
            case 3 -> {
                sorted.sort(new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        return Integer.compare(o1.getPrice(), o2.getPrice());
                    }
                });
            }
            case 4 -> {
                sorted.sort(new Comparator<Item>() {
                    @Override
                    public int compare(Item o1, Item o2) {
                        return o1.getBrand().getName().compareTo(o2.getBrand().getName());
                    }
                });
            }
        }

        return sorted;
    }
}
