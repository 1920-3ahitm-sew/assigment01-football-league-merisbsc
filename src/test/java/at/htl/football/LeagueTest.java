package at.htl.football;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LeagueTest {

    @Test
    void addMatchResultTest() {
        Match match = new Match("home", "guest", 3, 1);
        Team home = new Team("home");

        home.addMatch(match);
        assertThat(home.getPoints(), is(3));
        assertThat(home.getGoalsShot(), is(3));
        assertThat(home.getGoalsReceived(), is(1));
        assertThat(home.getWins(), is(1));
        assertThat(home.getGoalDifference(), is(2));

    }

}