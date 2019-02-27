import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RainfallTests {

    @Test
    void lowestMonthTest() {
        double[] rainFallAmounts = new double[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        Rainfall rainFall = new Rainfall(rainFallAmounts);

        String actual = rainFall.lowestMonth();
        assertEquals("Jan", actual);
    }

    @Test
    void highestMonthTest() {
        double[] rainFallAmounts = new double[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        Rainfall rainFall = new Rainfall(rainFallAmounts);

        String actual = rainFall.highestMonth();
        assertEquals("Dec", actual);
    }

    @Test
    void annualRainfallTest() {
        double[] rainFallAmounts = new double[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        Rainfall rainFall = new Rainfall(rainFallAmounts);

        double actual = rainFall.annualRainfall();
        assertEquals(186.0, actual);
    }

    @Test
    void averageRainfallTest() {
        double[] rainFallAmounts = new double[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
        Rainfall rainFall = new Rainfall(rainFallAmounts);

        double actual = rainFall.averageRainfall();
        assertEquals(15.5, actual);
    }


}
