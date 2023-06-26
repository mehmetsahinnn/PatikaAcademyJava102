package AdventureGame;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, "Forest", new Vampire("Vampire", 2, 4, 25));
    }
}
