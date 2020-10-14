package group_stage.solution;

import java.util.*;

public class GroupStage {
    private final Map<String, Team> teams;
    private final List<String> result;

    public GroupStage(Map<String, Team> teams, List<String> result) {
        this.teams = teams;
        this.result = result;
    }

    public void printInfo() {
        parsing();

        List<Team> teamList = new ArrayList<>(teams.values());
        Collections.sort(teamList);
        printStanding(teamList);
    }

    private void parsing() {
        for(String data : this.result) {
            String[] split = data.split(" ");

            String team1 = split[0];
            String score = split[1];
            String team2 = split[2];

            int score1 = Integer.parseInt(score.split(":")[0]);
            int score2 = Integer.parseInt(score.split(":")[1]);

            Team t1 = this.teams.get(team1);
            Team t2 = this.teams.get(team2);

            if(score1 > score2) {
                t1.getWins().put(team2, split[1]);
                t2.getLoses().put(team1, split[1]);
            }
            else {
                t1.getLoses().put(team2, split[1]);
                t2.getWins().put(team1, split[1]);
            }
        }
    }

    private void printStanding(List<Team> sorted) {
        for(int i=0; i<sorted.size(); i++) {
            Team team = sorted.get(i);
            StringBuilder sb = new StringBuilder();

            sb.append(i + 1).append(") ");
            sb.append(team.getName()).append(" ");
            sb.append(team.getWins().size()).append(" ");
            sb.append(team.getLoses().size()).append(" ");

            int winSets = team.numOfWinSets();
            int loseSets = team.numOfLoseSets();

            sb.append(winSets).append("-").append(loseSets).append(" ");
            sb.append(winSets - loseSets);

            System.out.println(sb.toString());
        }
    }
}
