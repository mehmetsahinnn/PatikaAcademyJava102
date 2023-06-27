package AdventureGame;

import java.util.Random;

public abstract class BattleLocation extends Location {

    private final Monster monster;


    public BattleLocation(Player player, String name, Monster monster) {
        super(player, name);
        this.monster = monster;
    }

    @Override
    public boolean onLocation() {
        return true;
    }

    void battleDrop() {
        Random random = new Random();
        int weaponChance = random.nextInt(100);
        int armorChance = random.nextInt(100);
        int moneyChance = random.nextInt(100);
        if (weaponChance < 15) {
            if (weaponChance < 3) {
                System.out.println("You obtained a Rocket Launcher!");
                getPlayer().getInventory().setWeapon(Weapon.weapons()[5]);
            }
            if (weaponChance < 6 && weaponChance > 2) {
                System.out.println("You obtained a Machine Gun!");
                getPlayer().getInventory().setWeapon(Weapon.weapons()[4]);
            }
            if (weaponChance > 7) {
                System.out.println("You obtained a Shotgun!");
                getPlayer().getInventory().setWeapon(Weapon.weapons()[3]);
            }
        }
        if (armorChance < 15) {
            if (armorChance < 3) {
                System.out.println("You obtained a Heavy Armor!");
                getPlayer().getInventory().setArmor(Armor.armors()[2]);
            }
            if (armorChance < 6 && armorChance > 2) {
                System.out.println("You obtained a Medium Armor!");
                getPlayer().getInventory().setArmor(Armor.armors()[1]);
            }
            if (armorChance > 7) {
                System.out.println("You obtained a Light Armor!");
                getPlayer().getInventory().setArmor(Armor.armors()[0]);
            }
        }
        if (moneyChance < 20) {
            if (moneyChance < 5) {
                System.out.println("You obtained 10 Money!");
                getPlayer().setMoney(getPlayer().getMoney() + 10);
            }
            if (moneyChance < 11 && moneyChance > 5) {
                System.out.println("You obtained 5 Money!");
                getPlayer().setMoney(getPlayer().getMoney() + 5);
            }
            if (moneyChance > 10) {
                System.out.println("You obtained 1 Money!");
                getPlayer().setMoney(getPlayer().getMoney() + 1);
            }
        } else {
            System.out.println("You didn't obtain anything.");
        }
    }

    boolean combat(int monsterCount) {
        boolean result = true;
        for (int i = 1; i < monsterCount; i++) {
            Random random = new Random();
            int monsterHealth = random.nextInt(monster.getHealth()) + 1;
            while (true) {
                boolean isPlayerTurn = random.nextBoolean();
                if (isPlayerTurn) {
                    System.out.println("<A> for attack");
                    System.out.println("<E> for escape");
                    String selectCase = scanner.nextLine().toUpperCase();
                    if (selectCase.equals("A")) {
                        System.out.println();
                        int playerDamage = random.nextInt(getPlayer().getDamage()) + 1;
                        System.out.println("You attacked " + playerDamage);
                        monsterHealth -= playerDamage;
                        if (monsterHealth <= 0) {
                            System.out.println("You killed " + i + ". monster");
                            break;
                        }
                        System.out.println("Monster health: " + monsterHealth);
                        System.out.println();
                    } else if (selectCase.equals("E")) {
                        location = new SafeHouse(getPlayer());
                        break;
                    }
                } else {
                    System.out.println("Monster turn");
                    int monsterAttack = random.nextInt(monster.getDamage()) + 5;
                    System.out.println("Monster attacked " + monsterAttack);
                    getPlayer().setHealth(getPlayer().getHealth() - (monsterAttack) + ((getPlayer().getInventory().getArmor().getBlock()) / 100));
                    if (getPlayer().getHealth() <= 0) {
                        System.out.println("You lost");
                        result = false;
                        break;
                    }
                    System.out.println("Your health: " + getPlayer().getHealth());
                    System.out.println();
                }
            }
            if (!result) break;
        }
        battleDrop();
        if (result) {
            result = false;
        }
        return result;
    }
}

