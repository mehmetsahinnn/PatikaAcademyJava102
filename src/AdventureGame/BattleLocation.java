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
        Random random = new Random();
        int monsterCount = random.nextInt(10) + 2;
        System.out.println("You are in " + getName() + " and there are " + monsterCount + " monsters");
        System.out.println("<S> for run");
        System.out.println("<A> for attack");
        String selectCase = scanner.nextLine().toUpperCase();
        if (selectCase.equals("S")) {
            if (random.nextInt(100) <= 20) {
                System.out.println("You escaped");
                return true;
            }
        }
        if (selectCase.equals("A")) {
            if (combat(monsterCount)) {
                System.out.println("You won");
                getPlayer().setMoney(getPlayer().getMoney() + 20);
                return true;
            }
            if (getPlayer().getHealth() <= 0) {
                System.out.println("Game Over");
                return false;
            }
        }
        if (selectCase.equals("E")) {
            location = new SafeHouse(getPlayer());
        }
        return true;
    }


    private boolean combat(int monsterCount) {
        for (int i = 1; i < monsterCount; i++) {
            Random random = new Random();
            int monsterHealth = random.nextInt(monster.getHealth()) + 1;
            while (true) {
                System.out.println("<A> for attack");
                System.out.println("<E> for escape");
                String selectCase = scanner.nextLine().toUpperCase();
                if (selectCase.equals("A")) {
                    System.out.println();
                    int playerDamage = random.nextInt(getPlayer().getDamage())+1;
                    System.out.println("You attacked " + playerDamage);
                    monsterHealth -= playerDamage;
                    if (monsterHealth <= 0) {
                        System.out.println("You killed " + i + ". monster");
                        break;
                    }
                    System.out.println("Monster health: " + monsterHealth);
                    System.out.println();
                    int monsterAttack = random.nextInt(monster.getDamage()) + 5;
                    System.out.println("Monster attacked " + monsterAttack);
                    getPlayer().setHealth(getPlayer().getHealth() - (monsterAttack) + ((getPlayer().getInventory().getArmor().getBlock())/100));
                    if (getPlayer().getHealth() <= 0) {
                        System.out.println("You lost");
                        return false;
                    }
                    System.out.println("Your health: " + getPlayer().getHealth());
                    System.out.println();
                } else if (selectCase.equals("E")) {
                    location = new SafeHouse(getPlayer());
                    break;
                }
            }
            getPlayer().setMoney(getPlayer().getMoney() + 20);
        }
        return false;
    }
}

