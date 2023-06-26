package AdventureGame;

public class SafeHouse extends NormalLocation {
    public SafeHouse(Player player) {
        super(player, "Safe House");
        player.setHealth(100);
        System.out.println("Health Regenerated");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Safe House");
        System.out.println("-------------------------");
        System.out.println("Your current weapon is " + getPlayer().inventory.getWeaponName());
        System.out.println("Your current armor is " + getPlayer().inventory.getArmorName());
        System.out.println("-------------------------");
        return true;
    }
}
