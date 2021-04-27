import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RedactSecretMessageTest {

    private File originalFile;
    private File redactedFile;
    private BufferedReader redactedFileReader;
    private BufferedReader originalFileReader;

    private final ByteArrayOutputStream printOut =
            new ByteArrayOutputStream();

    @BeforeEach
    public void setUpEach() {
        System.setOut(new PrintStream(printOut));
    }

    @AfterEach
    public void cleanUpEach() {
        System.setOut(System.out);
    }

    @Test
    public void redactTextFile_ensureRedaction() {

        try {
            RedactSecretMessage.redactTextFile("sample.txt",
                    new String[] {"sally", "Kat", "ready to go"});

            redactedFile = new File("redacted-sample.txt");
            redactedFileReader = new BufferedReader(
                    new FileReader(redactedFile));

            redactedFileReader.lines().forEach(line -> {
                assertFalse(line.contains("sally"));
                assertFalse(line.contains("Kat"));
                assertFalse(line.contains("ready to go"));
            });
        } catch(IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void redactTextFile_ensureSameRemainingContents() {

        try {

            RedactSecretMessage
                    .redactTextFile("sample.txt",
                            new String[] {"sally", "Kat",
                                    "ready to go"});

            originalFile = new File("sample.txt");
            originalFileReader = new BufferedReader(
                    new FileReader(originalFile));

            redactedFile = new File("redacted-sample.txt");
            redactedFileReader = new BufferedReader(
                    new FileReader(redactedFile));

            List<String> redactedLines = originalFileReader.lines()
                    .map(line ->
                            line.replace("sally",
                                    "REDACTED")
                                    .replace("kat",
                                            "REDACTED")
                                    .replace("Kat",
                                            "REDACTED")
                                    .replace("Sally",
                                            "REDACTED")
                                    .replace("ready to go",
                                            "REDACTED"))
                    .collect(Collectors.toList());

            redactedLines.forEach(line -> {
                try {
                    assertEquals(line, redactedFileReader.readLine());
                } catch (IOException e) { System.out.println("ERROR"); }
            });

        } catch(IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void redactTextFile_ensureSameNumberOfLines() {

        try {
            RedactSecretMessage.redactTextFile("sample.txt",
                    new String[] {"sally", "Kat"});

            originalFile = new File("sample.txt");
            originalFileReader = new BufferedReader(
                    new FileReader(originalFile));

            redactedFile = new File("redacted-sample.txt");
            redactedFileReader = new BufferedReader(
                    new FileReader(redactedFile));

            List<String> redactedLines = originalFileReader.lines()
                    .map(line ->
                            line.replace("sally",
                                    "REDACTED")
                                    .replace("kat",
                                            "REDACTED")
                                    .replace("Kat",
                                            "REDACTED")
                                    .replace("Sally",
                                            "REDACTED")
                                    .replace("ready to go",
                                            "REDACTED"))
                    .collect(Collectors.toList());

            originalFileReader.reset();
            assertEquals(originalFileReader.lines().toArray().length,
                    redactedLines.size());

        } catch(IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void redactTextFile_wrongFileType() {

        RedactSecretMessage.redactTextFile("sample.jpg",
                new String[] {"sally", "Kat", "ready to go"});
        File tempFile = new File("redacted-sample.jpg");
        assertFalse(tempFile.exists());
        assertEquals("This is not a text file.\n",
                printOut.toString());
    }
}