import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {

    private static final String PLAYER_ONE = "Sally";
    private static final String PLAYER_TWO = "Roger";

    @Test
    public void teamAttributes() {

        Team team = new Team(PLAYER_ONE, PLAYER_TWO);

        assertEquals(PLAYER_ONE, team.getPlayer1());
        assertEquals(PLAYER_TWO, team.getPlayer2());
        assertEquals(List.of(), team.getScores());
    }
}