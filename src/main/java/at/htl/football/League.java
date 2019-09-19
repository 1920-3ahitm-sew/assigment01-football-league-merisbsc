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
            teams.add(new Team("test"));
        }
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            } else {
                teams.add(new Team(name));

            }
        }
        return null;
    }

    public void getTable() {
        Collections.sort(teams);

        System.out.println("Team            Pts   W   D   L   GF  GA  GD");
        for (Team team : teams) {
            System.out.println(team.getName() + "            " + team.getPoints() + "    " + team.getWins() + "  " + team.getDraws() + "     " + team.getDefeats() + "  " + team.getGoalsShot() + "   " + team.getGoalsReceived() + "    " + team.getGoalDifference());
        }
    }
}
