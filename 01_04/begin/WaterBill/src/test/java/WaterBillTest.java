import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WaterBillTest {

    @Test
    public void calculateWaterBill() {
        assertEquals(22.74,
                WaterBill.calculateWaterBill(1800));
        assertEquals(22.74,
                WaterBill.calculateWaterBill(2244));
        assertEquals(26.64,
                WaterBill.calculateWaterBill(2245));
        assertEquals(26.64,
                WaterBill.calculateWaterBill(2992));
        assertEquals(46.14,
                WaterBill.calculateWaterBill(6000));
        assertEquals(53.94,
                WaterBill.calculateWaterBill(8000));


        assertEquals(18.84,
                WaterBill.calculateWaterBill(0));
        assertEquals(18.84,
                WaterBill.calculateWaterBill(1496));
        assertEquals(22.74,
                WaterBill.calculateWaterBill(1497));
        assertEquals(18.84,
                WaterBill.calculateWaterBill(-20));
    }

}
