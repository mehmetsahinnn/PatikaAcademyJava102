package AdventureGame;

import java.util.Scanner;

public class Game {
    Scanner scanner;
    Location location;
    boolean game;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.location = new Location();
        this.game = false;
    }

    public void start() {
        this.game = true;
        System.out.println("Welcome to the adventure game !");
        System.out.print("Please select your name : ");
        String playerName = this.scanner.nextLine();
        System.out.print("Please select your character : ");
        String character = this.scanner.nextLine();
        Player player = new Player(playerName);
        player.selectChar(character);
    }
}
