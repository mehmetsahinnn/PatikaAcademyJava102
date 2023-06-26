package AdventureGame;

public class Weapon {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Weapon(String name, int id, int damage, int price) {
        this.id = id;
        this.damage = damage;
        this.price = price;
        this.name = name;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[6];
        weaponList[0] = new Weapon("Katana", 1, 20, 2);
        weaponList[1] = new Weapon("Arrow", 2, 7, 4);
        weaponList[2] = new Weapon("Sword", 3, 15, 7);
        weaponList[3] = new Weapon("Shotgun", 4, 3, 3);
        weaponList[4] = new Weapon("Machine Gun", 5, 5, 5);
        weaponList[5] = new Weapon("Rocket Launcher", 6, 25, 10);
        return weaponList;
    }

    ;


    public int getId() {
        return this.id;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getPrice() {
        return this.price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
