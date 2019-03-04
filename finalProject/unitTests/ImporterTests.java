import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ImporterTests {

    @Test
    void importFirstLine() {
        Importer importer = new Importer();
        ArrayList<Person> actualPeople = importer.importPeople();
    }
}
