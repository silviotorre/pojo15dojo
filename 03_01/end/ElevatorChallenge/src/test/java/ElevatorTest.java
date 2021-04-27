import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElevatorTest {

    private final ByteArrayOutputStream printOut =
            new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(printOut));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void callElevator() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.setProcessingTime(10);

        elevator.callElevator(0, 4);
        elevator.start();
        assertEquals(4, elevator.getCurrentFloor());

        elevator.callElevator(0, 5);
        elevator.start();
        assertEquals(5, elevator.getCurrentFloor());

        elevator.callElevator(1, 5);
        elevator.start();
        assertEquals(5, elevator.getCurrentFloor());

        elevator.callElevator(4, 10);
        elevator.start();
        assertEquals(10, elevator.getCurrentFloor());

        elevator.callElevator(10, 7);
        elevator.start();
        assertEquals(7, elevator.getCurrentFloor());
    }

    @Test
    public void callElevator_invalidStart() {
        Elevator elevator = new Elevator();

        elevator.callElevator(-3, 8);

        assertEquals(0, elevator.getCurrentFloor());
        assertEquals("INVALID FLOORS. Try again\n",
                printOut.toString());
    }

    @Test
    public void callElevator_invalidDestination() {
        Elevator elevator = new Elevator();

        elevator.callElevator(0, 14);
        assertEquals(0, elevator.getCurrentFloor());
        assertEquals("INVALID FLOORS. Try again\n",
                printOut.toString());
    }

    @Test
    public void callElevator_sameStartAndDestination() {
        Elevator elevator = new Elevator();

        elevator.callElevator(5, 5);
        assertEquals(0, elevator.getCurrentFloor());
        assertEquals("INVALID FLOORS. Try again\n",
                printOut.toString());
    }

    @Test
    public void startElevator() throws InterruptedException {
        Elevator elevator = new Elevator();
        elevator.setProcessingTime(10);

        elevator.callElevator(0, 4);
        elevator.callElevator(0, 5);
        elevator.callElevator(1, 5);
        elevator.callElevator(4, 6);
        elevator.callElevator(-3, 8);
        elevator.callElevator(0, 18);
        elevator.callElevator(8, 4);
        elevator.callElevator(10, 2);

        elevator.start();

        assertEquals("INVALID FLOORS. Try again\n" +
                "INVALID FLOORS. Try again\n" +
                "--------\n" +
                "BOARDING at Floor 0\n" +
                "GOING UP TO 1\n" +
                "--------\n" +
                "--------\n" +
                "BOARDING at Floor 1\n" +
                "GOING UP TO 2\n" +
                "--------\n" +
                "--------\n" +
                "GOING UP TO 3\n" +
                "--------\n" +
                "--------\n" +
                "GOING UP TO 4\n" +
                "--------\n" +
                "--------\n" +
                "UNBOARDING at Floor 4\n" +
                "BOARDING at Floor 4\n" +
                "GOING UP TO 5\n" +
                "--------\n" +
                "--------\n" +
                "UNBOARDING at Floor 5\n" +
                "GOING UP TO 6\n" +
                "--------\n" +
                "--------\n" +
                "UNBOARDING at Floor 6\n" +
                "GOING UP TO 7\n" +
                "--------\n" +
                "--------\n" +
                "GOING UP TO 8\n" +
                "--------\n" +
                "--------\n" +
                "BOARDING at Floor 8\n" +
                "GOING UP TO 9\n" +
                "--------\n" +
                "--------\n" +
                "GOING UP TO 10\n" +
                "--------\n" +
                "--------\n" +
                "BOARDING at Floor 10\n" +
                "GOING DOWN TO 9\n" +
                "--------\n" +
                "--------\n" +
                "GOING DOWN TO 8\n" +
                "--------\n" +
                "--------\n" +
                "GOING DOWN TO 7\n" +
                "--------\n" +
                "--------\n" +
                "GOING DOWN TO 6\n" +
                "--------\n" +
                "--------\n" +
                "GOING DOWN TO 5\n" +
                "--------\n" +
                "--------\n" +
                "GOING DOWN TO 4\n" +
                "--------\n" +
                "--------\n" +
                "UNBOARDING at Floor 4\n" +
                "GOING DOWN TO 3\n" +
                "--------\n" +
                "--------\n" +
                "GOING DOWN TO 2\n" +
                "--------\n" +
                "--------\n" +
                "UNBOARDING at Floor 2\n" +
                "--------\n" +
                "No one is waiting and no one is looking to " +
                "go anywhere\n" +
                "Chilling for now\n", printOut.toString());

        assertEquals(Map.of(), elevator.getRequestedPathsMap());
        assertFalse(Arrays
                .asList(elevator.getCurrentFloorDestinations())
                .contains(Boolean.TRUE));
    }
}