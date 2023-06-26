package AdventureGame;

import java.util.Objects;
import java.util.Scanner;

public class Player extends Game {
    Scanner scanner = new Scanner(System.in);
    Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory(this);
    }


    public void selectChar(String charName) {
        if (Objects.equals(charName, "samurai")) {
            this.charName = "samurai";
            this.money = 15;
            this.health = 100;
            this.inventory.setWeapon(new Weapon("Katana", 1, 10, 0));
            this.setDamage(inventory.weaponDamage);
            this.inventory.setArmor(Armor.armors()[0]);
            this.damage = 20;
        } else if (Objects.equals(charName, "archer")) {
            this.charName = "archer";
            this.money = 20;
            this.health = 100;
            this.inventory.setWeapon(new Weapon("Arrow", 2, 10, 0));
            this.setDamage(inventory.weaponDamage);
            this.inventory.setArmor(Armor.armors()[0]);
            this.damage = 7;
        } else if (Objects.equals(charName, "knight")) {
            this.charName = "knight";
            this.money = 5;
            this.health = 100;
            this.inventory.setWeapon(new Weapon("Sword", 3, 10, 0));
            this.setDamage(inventory.weaponDamage);
            this.inventory.setArmor(Armor.armors()[0]);
            this.damage = 15;
        } else {
            System.out.print("Please enter a valid character : ");
            selectChar(scanner.next());
        }
    }

    protected void printInfo() {
        System.out.println(
                "Name : " + this.getName() +
                        "\nCharacter : " + this.getCharName() +
                        "\nHealth : " + this.getHealth() +
                        "\nDamage : " + this.inventory.getWeaponDamage() +
                        "\nBlock : " + this.inventory.getArmorDefence() +
                        "\nMoney : " + this.getMoney() +
                        "\nWeapon : " + this.getInventory().getWeapon().getName()
        );
    }


    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return this.charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
