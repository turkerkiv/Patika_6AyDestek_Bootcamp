package Week4.Adventure_Game;

import java.util.List;

public class Shop extends SafePlace{
    List<Armor> armors;
    List<Weapon> weapons;

    Shop(String name, int ID) {
        super(name, ID);
        fillShopStocks();
    }

    private void fillShopStocks()
    {
        //TODO
    }

    public void buyArmor(int armorID)
    {
        //TODO
    }

    public void buyWeapon(int weaponID)
    {
        //TODO
    }
}
