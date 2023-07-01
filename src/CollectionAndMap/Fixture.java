package CollectionAndMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fixture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many teams will be? ");
        int numTeams = scanner.nextInt();
        scanner.nextLine();

        List<String> teams = new ArrayList<>();

        for (int i = 0; i < numTeams; i++) {
            System.out.print("Enter a team name: ");
            String teamName = scanner.nextLine();
            teams.add(teamName);
        }

        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        int numRounds = teams.size() - 1;
        int halfSize = teams.size() / 2;

        for (int round = 1; round <= numRounds; round++) {
            System.out.println("Round " + round);
            for (int i = 0; i < halfSize; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(teams.size() - 1 - i);
                System.out.println(homeTeam + " vs " + awayTeam);
            }
            rotateTeams(teams);
        }
        for (int round = numRounds+1; round <= numRounds*2; round++) {
            System.out.println("Round " + round);
            for (int i = 0; i < halfSize; i++) {
                String homeTeam = teams.get(i);
                String awayTeam = teams.get(teams.size() - 1 - i);
                System.out.println(awayTeam + " vs " + homeTeam);
            }
            rotateTeams(teams);
        }

        scanner.close();
    }

    private static void rotateTeams(List<String> teams) {
        String lastTeam = teams.remove(teams.size() - 1);
        teams.add(1, lastTeam);
    }
}
