import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class JokeGeneratorTest {

    private static final String SETUP = "Get ready...";
    private static final String PUNCHLINE = "For the punchline!";

    private final ByteArrayOutputStream printOut =
            new ByteArrayOutputStream();

    private final Joke joke = new Joke();

    @BeforeEach
    public void setUpEach() {

        System.setOut(new PrintStream(printOut));
    }

    @AfterEach
    public void cleanUpEach() {

        System.setOut(System.out);
    }

    @Test
    public void parseJoke() {

        Optional<Joke> jokeOpt =  JokeGenerator
                .parseJoke("[{\"id\":16,\"type\"" +
                        ":\"programming\",\"setup\":\""+ SETUP +
                        "\",\"punchline\":\""+ PUNCHLINE +"\"}]");

        assertTrue(jokeOpt.isPresent());
        assertEquals(SETUP, jokeOpt.get().getSetup());
        assertEquals(PUNCHLINE, jokeOpt.get().getPunchline());
    }

    @Test
    public void parseJoke_parseError() {

        Optional<Joke> jokeOpt = JokeGenerator
                .parseJoke("today");

        assertFalse(jokeOpt.isPresent());
        assertEquals("Must be out of jokes for now.\n",
                printOut.toString());
    }

    @Test
    public void parseJoke_noJokes() {

        Optional<Joke> jokeOpt = JokeGenerator
                .parseJoke("[]");

        assertFalse(jokeOpt.isPresent());
    }

    @Test
    public void tellJoke() {

        joke.setSetup(SETUP);
        joke.setPunchline(PUNCHLINE);

        JokeGenerator.tellJoke(joke);

        assertEquals("""
                Get ready...
                For the punchline!
                """, printOut.toString());
    }
}
