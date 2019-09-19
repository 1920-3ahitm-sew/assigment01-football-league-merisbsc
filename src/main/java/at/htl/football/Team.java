package at.htl.football;

public class Team extends League implements Comparable<Team>{

    private String name;
    private int points = 0;
    private int wins = 0;
    private int draws = 0;
    private int defeats = 0;
    private int goalsShot = 0;
    private int goalsReceived = 0;

    public Team(String name) {
        this.name = name;
    }

    //region getter
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalDifference() {
        return getGoalsShot() - getGoalsReceived();
    }
    //endregion

    public void addMatch(Match match) {
        //points & wins ausrechnen
        if (match.getHomeGoals() > match.getGuestGoals()) {
            points += 3;
            wins++;
        } else if (match.getHomeGoals() == match.getGuestGoals()) {
            points++;
            draws++;
        } else {
            defeats++;
        }

        goalsShot += match.getHomeGoals();
        goalsReceived += match.getGuestGoals();
    }

    public int compareTo(Team team2) {

        return 0;
    }

}
