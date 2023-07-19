package Week4.Adventure_Game;

public class PlayerInventory {
    private Weapon currentWeapon;
    private Armor currentArmor;
    private boolean hasFirewood;
    private boolean hasWater;
    private boolean hasFood;

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

    public void setHasFirewood(boolean hasFirewood) {
        this.hasFirewood = hasFirewood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }
}
