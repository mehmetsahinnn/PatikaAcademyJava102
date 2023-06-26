package AdventureGame;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Cave", new Zombie("Zombie", 2, 4, 14));
    }
}
