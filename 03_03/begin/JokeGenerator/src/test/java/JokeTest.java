import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokeTest {

    @Test
    public void jokeAttributes() {

        Joke joke = new Joke();

        String SETUP = "Get ready...";
        String PUNCHLINE = "For the punchline!";

        joke.setSetup(SETUP);
        joke.setPunchline(PUNCHLINE);

        assertEquals(SETUP, joke.getSetup());
        assertEquals(PUNCHLINE, joke.getPunchline());
    }
}
