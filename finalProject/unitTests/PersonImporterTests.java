import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PersonImporterTests {

    @Test
    void importFirstLine() {
        PersonImporter personImporter = new PersonImporter("titanic.csv");
        personImporter.parsePeople();
    }
}
