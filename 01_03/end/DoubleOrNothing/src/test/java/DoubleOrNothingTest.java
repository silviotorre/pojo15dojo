import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleOrNothingTest {

    private final ByteArrayOutputStream gamePrintOut =
            new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(gamePrintOut));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void askUserToContinue_YES() {

        String input = "yes";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        DoubleOrNothing game = new DoubleOrNothing();
        assertTrue(game.getIsStillPlaying());

        game.askUserToContinue();
        assertTrue(game.getIsStillPlaying());
        assertEquals("Would you like to continue " +
                "and try to double your winnings? " +
                "Enter YES to continue\n", gamePrintOut.toString());
    }

    @Test
    public void askUserToContinue_NO() {
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        DoubleOrNothing game = new DoubleOrNothing();
        assertTrue(game.getIsStillPlaying());

        game.askUserToContinue();
        assertFalse(game.getIsStillPlaying());
        assertEquals("Would you like to continue " +
                "and try to double your winnings? " +
                "Enter YES to continue\n", gamePrintOut.toString());
    }
}