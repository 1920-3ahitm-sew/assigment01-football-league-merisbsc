package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {

    private List<Team> teams = new ArrayList<>();

    void addMatchResult(Match match) {
        Team home = findOrCreateTeam(match.getHomeName());
        Team guest = findOrCreateTeam(match.getGuestName());

        home.addMatch(match);
        guest.addMatch(match);
    }

    private Team findOrCreateTeam(String name) {
        if (teams.size() == 0) {
            teams.add(new Team(name));
        }
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        Team newTeam = new Team(name);
        teams.add(newTeam);
        return newTeam;
    }

    public void getTable() {
        Collections.sort(teams);

        System.out.format("%18s   %s   %s    %s    %s   %s   %s   %s\n","Team","Pts","W","D","L","GF","GA","GD");
        for (Team team : teams) {
            //System.out.println(team.getName() + "      " + team.getPoints() + "   " + team.getWins() + "   " + team.getDraws() + "   " + team.getDefeats() + "   " + team.getGoalsShot() + "   " + team.getGoalsReceived() + "   " + team.getGoalDifference());
            System.out.format("%18s   %2d   %2d   %2d   %2d   %2d   %2d   %2d\n", team.getName(), team.getPoints(),team.getWins(), team.getDraws(), team.getDefeats(), team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
        }
    }
}
