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

    public List<Team> getTable() {
        Collections.sort(teams);
        return teams;
    }
}
