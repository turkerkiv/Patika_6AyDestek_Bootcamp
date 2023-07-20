package Week4.Adventure_Game;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
    private Weapon currentWeapon;
    private Armor currentArmor;
    private final List<Item> rewards;

    PlayerInventory()
    {
        rewards = new ArrayList<>();
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Armor getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(Armor currentArmor) {
        this.currentArmor = currentArmor;
    }

    public void addRewardItem(Item item){
        if(rewards.contains(item))
        {
            return;
        }
        rewards.add(item);
    }
}
