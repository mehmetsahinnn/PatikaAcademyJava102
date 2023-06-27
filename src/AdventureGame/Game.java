package AdventureGame;

import java.util.Scanner;

public class Game {
    Scanner scanner;
    Location location;
    boolean game;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.game = true;
    }


    public void start() {
        this.game = true;
        System.out.println("Welcome to the adventure game !");
        System.out.print("Please select your name : ");
        String playerName = this.scanner.nextLine();
        playerName = playerName.substring(0, 1).toUpperCase() + playerName.substring(1).toLowerCase();
        System.out.print("Please select your character : ");
        String character = this.scanner.nextLine();
        Player player = new Player(playerName);
        player.selectChar(character);


        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("Where do you want to go ? (Safe House/Tool Store or Cave/River/Forest/Mine) : ");
            String selection = scanner.nextLine().toLowerCase();

            switch (selection) {
                case "safe house" -> location = new SafeHouse(player);
                case "tool store" -> location = new Toolstore(player);
                case "cave" -> location = new Cave(player);
                case "forest" -> location = new Forest(player);
                case "river" -> location = new River(player);
                case "mine" -> location = new Mine(player);
            }

            assert location != null;

            if (!location.onLocation()) {
                System.out.println("Out Of Bounds");
                break;
            }
        }
    }
}
