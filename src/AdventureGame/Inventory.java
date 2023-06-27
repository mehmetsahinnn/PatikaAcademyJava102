package AdventureGame;

public class Inventory {
    boolean water;
    boolean food;
    boolean firewood;
    boolean emerald;
    String weaponName;
    String armorName;
    int weaponDamage;
    int armorDefence;
    Weapon weapon;
    Armor armor;
    Player player;

    public Inventory(Player player) {
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.emerald = false;
        this.weaponName = "Fists";
        this.armorName = "Clothes";
        this.weaponDamage = getWeaponDamage();
        this.armorDefence = getArmorDefence();
        this.weapon = getWeapon();
        this.armor = getArmor();
    }


    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isEmerald() {
        return emerald;
    }

    public void setEmerald(boolean emerald) {
        this.emerald = emerald;
    }
}
