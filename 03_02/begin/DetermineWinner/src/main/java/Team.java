import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Team {
    
    private final String player1;
    private final String player2;
    private final List<Integer> scores;

    public Team(String player1, String player2) {

        this.player1 = player1;
        this.player2 = player2;
        scores = new ArrayList<>();
    }
}

