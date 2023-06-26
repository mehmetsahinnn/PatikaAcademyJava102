package AdventureGame;

public class Toolstore extends NormalLocation {
    public Toolstore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Tool Store");
        System.out.println("To buy press (1 for guns / 2 for armor) 3 for exit");
        int selectWeapon = scanner.nextInt();
        switch (selectWeapon) {
            case 1 -> weapons();
            case 2 -> armors();
            case 3 -> onLocation();
            default -> {
                System.out.println("Invalid menu");
                onLocation();
            }
        }
        return true;
    }


    public void weapons() {
        System.out.println("Weapons");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(
                    "Id: " + w.getId() +
                            " Name: " + w.getName() +
                            " Damage: " + w.getDamage() +
                            " Price: " + w.getPrice());
        }
        System.out.println("Select a weapon");
        int selectWeapon = scanner.nextInt();
        while (selectWeapon != 0) {
            for (Weapon w : Weapon.weapons()) {
                if (w.getId() == selectWeapon) {
                    if (w.getPrice() > getPlayer().getMoney()) {
                        System.out.println("You don't have enough money");
                        break;
                    }
                    getPlayer().inventory.setWeapon(w);
                    getPlayer().inventory.setWeaponName(w.getName());
                    getPlayer().inventory.setWeaponDamage(w.getDamage());
                    getPlayer().setMoney(getPlayer().getMoney() - w.getPrice());
                    System.out.println("You bought " + w.getName());
                    break;
                }
            }
            System.out.println("Select a weapon");
            selectWeapon = scanner.nextInt();
        }
    }

    public void armors() {
        System.out.println("Armors");
        for (Armor a : Armor.armors()) {
            System.out.println(
                    "Id: " + a.getId() +
                            " Name: " + a.getName() +
                            " Block: " + a.getBlock() +
                            " Price: " + a.getPrice());
        }
        System.out.println("Select a armor");
        int selectArmor = scanner.nextInt();
        while (selectArmor != 0) {
            for (Armor a : Armor.armors()) {
                if (a.getId() == selectArmor) {
                    if (a.getPrice() > getPlayer().getMoney()) {
                        System.out.println("You don't have enough money");
                        break;
                    }
                    getPlayer().inventory.setArmorName(a.getName());
                    getPlayer().inventory.setArmorDefence(a.getBlock());
                    getPlayer().setMoney(getPlayer().getMoney() - a.getPrice());
                    System.out.println("You bought " + a.getName());
                    break;
                }
            }
            System.out.println("Select a armor");
            selectArmor = scanner.nextInt();
        }
    }

    void menu() {

    }

    void buy() {

    }


}
