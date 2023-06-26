package AdventureGame;

import java.io.PrintStream;
import java.util.Objects;

public class Player extends Game {
    Inventory inventory = new Inventory();
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;

    public Player(String name) {
        this.name = name;
    }

    public void selectChar(String charName) {
        PrintStream var10000;
        String var10001;
        if (Objects.equals(charName, "samurai")) {
            this.charName = "samurai";
            this.money = 15;
            this.health = 21;
            this.damage = 5;
            var10000 = System.out;
            var10001 = this.getName();
            var10000.println(var10001 + " " + this.getCharName() + " : Money : " + this.getMoney() + " Health : " + this.getHealth() + " Damage : " + this.getDamage());
        } else if (Objects.equals(charName, "archer")) {
            this.charName = "archer";
            this.money = 20;
            this.health = 18;
            this.damage = 7;
            var10000 = System.out;
            var10001 = this.getName();
            var10000.println(var10001 + " " + this.getCharName() + " : Money : " + this.getMoney() + " Health : " + this.getHealth() + " Damage : " + this.getDamage());
        } else if (Objects.equals(charName, "knight")) {
            this.charName = "knight";
            this.money = 5;
            this.health = 24;
            this.damage = 8;
            var10000 = System.out;
            var10001 = this.getName();
            var10000.println(var10001 + " " + this.getCharName() + " : Money : " + this.getMoney() + " Health : " + this.getHealth() + " Damage : " + this.getDamage());
        } else {
            System.out.println("Please enter a valid character ! ");
            this.game = false;
        }

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
}
