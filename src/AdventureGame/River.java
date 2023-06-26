package AdventureGame;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear("Bear", 3, 8, 28));
    }
}
