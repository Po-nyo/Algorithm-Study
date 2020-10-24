package group_stage.solution;

import java.util.HashMap;
import java.util.Map;

public class Team implements Comparable<Team> {

    private String name;
    private Map<String, String> wins;
    private Map<String, String> loses;

    public Team(String name) {
        this.name = name;
        this.wins = new HashMap<>();
        this.loses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getWins() {
        return this.wins;
    }

    public Map<String, String> getLoses() {
        return this.loses;
    }

    public int numOfWinSets() {
        int num = 0;

        for(String key : this.wins.keySet()) {
            String[] score = this.wins.get(key).split(":");
            num += Math.max(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        for(String key : this.loses.keySet()) {
            String[] score = this.loses.get(key).split(":");
            num += Math.min(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        return num;
    }

    public int numOfLoseSets() {
        int num = 0;

        for(String key : this.wins.keySet()) {
            String[] score = this.wins.get(key).split(":");
            num += Math.min(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        for(String key : this.loses.keySet()) {
            String[] score = this.loses.get(key).split(":");
            num += Math.max(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        return num;
    }

    @Override
    public int compareTo(Team other) {
        int compared = Integer.compare(this.wins.size(), other.wins.size());
        if(compared != 0)
            return -compared;
        else {
            compared = Integer.compare(this.numOfWinSets() - this.numOfLoseSets(), other.numOfWinSets() - other.numOfLoseSets());
            if(compared != 0)
                return -compared;
            else {
                if(this.wins.containsKey(other.name))
                    return -1;
                else
                    return 1;
            }
        }
    }
}
