import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DaysFromNowTest {

    @Test
    public void calculateHundredDaysFromNow() {
        LocalDate d1 = LocalDate.of( 2020,
                1 , 1);
        assertEquals(LocalDate.of(2020, 4, 10),
                DaysFromNow.calculateHundredDaysFromNow(d1));

        LocalDate d2 = LocalDate.of( 2020 , 11 ,
                6);
        assertEquals(LocalDate.of(2021, 2, 14),
                DaysFromNow.calculateHundredDaysFromNow(d2));

        LocalDate d3 = LocalDate.of( 2022 , 11 ,
                8);
        assertEquals(LocalDate.of(2023, 2, 16),
                DaysFromNow.calculateHundredDaysFromNow(d3));
    }

}
