package group_stage.solution;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num_of_teams = scan.nextInt();
        scan.nextLine();

        Map<String, Team> teams = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i=0; i<num_of_teams; i++) {
            String teamName = scan.nextLine();
            teams.put(teamName, new Team(teamName));
        }

        while(scan.hasNextLine())
            result.add(scan.nextLine());

        new GroupStage(teams, result).printInfo();
    }
}
