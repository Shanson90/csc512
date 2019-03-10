import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.prefs.CsvPreference;

class PersonImporter {

    CsvMapReader csvReader;
    ArrayList<Person> people = new ArrayList<>();
    String[] nameMapping = new String[]{"PassengerId", "Survived", "Class", "Name", "Sex", "Age", "SameGenFam", "DiffGenFam", "Ticket", "Fare", "Cabin", "PortCode"};
    Map<String, Object> fieldsInCurrentRow;
    CellProcessor[] processors = getProcessors();

    PersonImporter(String fileName) throws Exception {
        File file = new File(fileName);
        csvReader = new CsvMapReader(new FileReader(file), CsvPreference.STANDARD_PREFERENCE);
    }

    private static CellProcessor[]getProcessors(){
        return new CellProcessor[]{
                new NotNull(new ParseInt()),    // PassengerId
                new Optional(),                 // Survived
                new Optional(new ParseInt()),   // Class
                new Optional(),                 // Name
                new Optional(),                 // Sex
                new Optional(new ParseDouble()),   // Age
                new Optional(new ParseInt()),   // SameGenFam
                new Optional(new ParseInt()),   // DiffGenFam
                new Optional(),                 // Ticket
                new Optional(new ParseDouble()),// Fare
                new Optional(),                 // Cabin
                new Optional()                  // PortCode
        };
    }

    void parsePeople() throws Exception {
        csvReader.getHeader(true);

        Person newPerson;
        int passengerId;
        boolean survived;
        int passengerClass;
        String fullName;
        boolean isMale;
        double age;
        int sameGenFam;
        int diffGenFam;
        String ticket;
        double fare;
        String cabin;
        String portCode;

        fieldsInCurrentRow = csvReader.read(nameMapping, processors);
        while (fieldsInCurrentRow != null) {
            passengerId = (int) fieldsInCurrentRow.get(nameMapping[0]);
            newPerson = new Person(passengerId);

            if (fieldsInCurrentRow.get(nameMapping[1]).equals("1")) {
                survived = true;
            } else if (fieldsInCurrentRow.get(nameMapping[1]).equals("0")) {
                survived = false;
            } else {
                throw new Exception("Survival other than 0 or 1 not supported.");
            }
            newPerson.setSurvival(survived);

            passengerClass = (int) fieldsInCurrentRow.get(nameMapping[2]);
            newPerson.setClass(passengerClass);

            fullName = (String) fieldsInCurrentRow.get(nameMapping[3]);
            newPerson.setName(fullName);

            if (fieldsInCurrentRow.get(nameMapping[4]).equals("male")) {
                isMale = true;
            } else if (fieldsInCurrentRow.get(nameMapping[4]).equals("female")) {
                isMale = false;
            } else {
                throw new Exception("Sex other than male or female is not supported.");
            }
            newPerson.setSex(isMale);

            if(fieldsInCurrentRow.get(nameMapping[5]) != null){
                age = (double) fieldsInCurrentRow.get(nameMapping[5]);
                newPerson.setAge(age);
            }

            sameGenFam = (int) fieldsInCurrentRow.get(nameMapping[6]);
            newPerson.setSameGenFamily(sameGenFam);

            diffGenFam = (int) fieldsInCurrentRow.get(nameMapping[7]);
            newPerson.setDiffGenFamily(diffGenFam);

            ticket = (String) fieldsInCurrentRow.get(nameMapping[8]);
            newPerson.setTicket(ticket);

            fare = (double) fieldsInCurrentRow.get(nameMapping[9]);
            newPerson.setFare(fare);

            cabin = (String) fieldsInCurrentRow.get(nameMapping[10]);
            newPerson.setCabin(cabin);

            if(fieldsInCurrentRow.get(nameMapping[11]) != null){
                portCode = (String) fieldsInCurrentRow.get(nameMapping[11]);
                newPerson.setPort(portCode);
            }

            people.add(newPerson);
            fieldsInCurrentRow = csvReader.read(nameMapping, processors);
        }
    }

    void sortByLastName() {
        

    }

    ArrayList<Person> getPeople() {
        return people;
    }



}



