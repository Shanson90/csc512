import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class selfDividingNumberTests {

    @Test
    void exampleOne() {
        List<Integer> actual = selfDividingNumber.findInRange(1, 22);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);

        assertEquals(expected, actual);
    }

    @Test
    void ten_through_twenty_four() {
        List<Integer> actual = selfDividingNumber.findInRange(10, 24);
        List<Integer> expected = Arrays.asList(11, 12, 15, 22, 24);

        assertEquals(expected, actual);
    }

    @Test
    void zero_through_eleven() {
        List<Integer> actual = selfDividingNumber.findInRange(0, 11);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11);

        assertEquals(expected, actual);
    }
}