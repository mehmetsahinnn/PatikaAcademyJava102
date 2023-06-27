package AdventureGame;

import java.util.Random;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear("Bear", 3, 8, 28));
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
                getPlayer().getInventory().setWater(true);
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
