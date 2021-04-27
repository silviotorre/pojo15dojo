import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterPointsTest {

    @Test
    public void scrabbleWordCalculator() {

        assertEquals(10,
                LetterPoints.wordScoreCalculator("very"));
        assertEquals(12,
                LetterPoints.wordScoreCalculator("zoo"));
        assertEquals(28,
                LetterPoints.wordScoreCalculator("maximize"));

        assertEquals(17,
                LetterPoints.wordScoreCalculator("exercise"));
        assertEquals(27,
                LetterPoints.wordScoreCalculator("jukebox"));
        assertEquals(26,
                LetterPoints.wordScoreCalculator("flapjack"));

        assertEquals(25,
                LetterPoints.wordScoreCalculator("squeeze"));
        assertEquals(11,
                LetterPoints.wordScoreCalculator("school"));
        assertEquals(9,
                LetterPoints.wordScoreCalculator("ex"));
        assertEquals(12,
                LetterPoints.wordScoreCalculator("common"));
    }

    @Test
    public void scrabbleWordCalculator_edgeCases() {

        assertEquals(0,
                LetterPoints.wordScoreCalculator(""));
        assertEquals(0,
                LetterPoints.wordScoreCalculator("          "));
        assertEquals(0,
                LetterPoints.wordScoreCalculator("     12-183     "));

        assertEquals(10,
                LetterPoints.wordScoreCalculator("v2ery"));
        assertEquals(10,
                LetterPoints.wordScoreCalculator("Very"));
        assertEquals(10,
                LetterPoints.wordScoreCalculator("VeRy"));

        assertEquals(10,
                LetterPoints.wordScoreCalculator("VERY"));
        assertEquals(10,
                LetterPoints.wordScoreCalculator("ver!y"));
        assertEquals(10,
                LetterPoints.wordScoreCalculator("ver!y"));

        assertEquals(10,
                LetterPoints.wordScoreCalculator("  ve ry"));
        assertEquals(10,
                LetterPoints.wordScoreCalculator("  ve ry"));
        assertEquals(7,
                LetterPoints.wordScoreCalculator("dadd"));
    }

}
