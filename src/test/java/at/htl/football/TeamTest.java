package at.htl.football;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void addMatch_Test_homeWin() {
        Match match = new Match("home", "guest", 3, 1);
        Team home = new Team("home");
        Team guest = new Team("guest");

        home.addMatch(match);
        guest.addMatch(match);

        assertThat(home.getPoints(), is(3));
        assertThat(guest.getPoints(), is(0));
    }

    @Test
    void addMatch_Test_guestWin() {
        Match match = new Match("home", "guest", 1, 2);
        Team home = new Team("home");
        Team guest = new Team("guest");

        home.addMatch(match);
        guest.addMatch(match);

        assertThat(home.getPoints(), is(0));
        assertThat(guest.getPoints(), is(3));
    }

    @Test
    void addMatch_Test_draw() {
        Match match = new Match("home", "guest", 1, 1);
        Team home = new Team("home");
        Team guest = new Team("guest");

        home.addMatch(match);
        guest.addMatch(match);

        assertThat(home.getPoints(), is(1));
        assertThat(guest.getPoints(), is(1));
    }

}