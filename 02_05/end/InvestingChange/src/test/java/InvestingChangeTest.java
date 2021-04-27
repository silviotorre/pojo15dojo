import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class InvestingChangeTest {

    @Test
    public void calculateAvgChangeInvested_empty() {
        assertEquals(0,
                InvestingChange
                        .calculateAvgChangeInvested(List.of()));
    }

    @Test
    public void calculateAvgChangeInvested_oneItem() {
        assertEquals(0.75,
                InvestingChange
                        .calculateAvgChangeInvested(List.of(19.25)));
    }

    @Test
    public void calculateAvgChangeInvested() {

        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        double estimatedAverageChangeInvested =
                ((13 - 12.38)
                        + (39 - 38.29)
                        + (6 - 5.27)
                        + (4 - 3.21)) / 4;
        assertEquals(estimatedAverageChangeInvested,
                InvestingChange.calculateAvgChangeInvested(purchases));

        purchases = List.of(19.99, 19.95, 29.95, 39.95, 19.99);
        estimatedAverageChangeInvested =
                ((20 - 19.99) + (20 - 19.95) +
                (30 - 29.95) + (40 - 39.95) + (20 - 19.99))
                        / 5;
        assertEquals(estimatedAverageChangeInvested,
                InvestingChange.calculateAvgChangeInvested(purchases));
    }
}
