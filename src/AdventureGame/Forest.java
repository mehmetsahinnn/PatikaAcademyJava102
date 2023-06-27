package AdventureGame;

import java.util.Random;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Forest", new Vampire("Vampire", 2, 4, 25));
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
                getPlayer().getInventory().setFirewood(true);
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
}
