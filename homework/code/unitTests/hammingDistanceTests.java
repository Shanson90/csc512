import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class hammingDistanceTests {

    @Test
    void exampleOne() {
        int actual = hammingDistance.calculate(1, 4);
        assertEquals(2, actual);
    }

    @Test
    void four_and_eight() {
        int actual = hammingDistance.calculate(4, 8);
        assertEquals(2, actual);
    }

    @Test
    void twenties() {
        int actual = hammingDistance.calculate(21, 25);
        assertEquals(2, actual);
    }

    @Test
    void big_numbers() {
        int actual = hammingDistance.calculate(1216610325, 680001561);
        assertEquals(6, actual);
    }




}