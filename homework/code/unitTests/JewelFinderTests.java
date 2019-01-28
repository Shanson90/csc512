import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class JewelFinderTests {
    // Example 1:
    // 	Input: J = "aA", S = "aAAbbbb"
    // 	Output: 3

    // Example 2:
    // 	Input: J = "z", S = "ZZ"
    // 	Output: 0

    @Test
    void exampleOne() {
        int actual = JewelFinder.findJewels("aA", "aAAbbbb");
        assertEquals(1, actual);
    }

    @Test
    void exampleTwo() {
        int actual = JewelFinder.findJewels("z", "ZZ");
        assertEquals(0, actual);
    }



}

