import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    static final DecimalFormat twoDec = new DecimalFormat("0.00");
    static final DecimalFormat intFormat = new DecimalFormat("0");
    static final DecimalFormat percent = new DecimalFormat("0%");

    // helpers to aggregate specific data on arrays of Persons/Families
    static PersonDataHelper personHelper = new PersonDataHelper();
    static FamilyDataHelper familyHelper = new FamilyDataHelper();

    public static void main(String[] args) throws Exception{
        // Import data into Person Classes
        PersonImporter importer = new PersonImporter("titanic.csv");
        importer.parsePeople();
        importer.sortByLastName();
        ArrayList<Person> sortedPeople = importer.getPeople();

        // Relate persons in Family Classes
        FamilyFinder famFinder = new FamilyFinder();
        ArrayList<Family> families = famFinder.findAll(sortedPeople);

        // Avg cost per person for all persons
        System.out.println("Average fare per person:  $" + twoDec.format(personHelper.averageFare(sortedPeople)));

        // Avg cost per person for persons in Families
        double totalFamilyFares = familyHelper.totalFares(families);
        double totalFamilyMembers = familyHelper.personCount(families);
        double averageFamilyMemberFare = totalFamilyFares / totalFamilyMembers;
        System.out.println("Average fare for those traveling with family:  $" + twoDec.format(averageFamilyMemberFare));

        ArrayList<Person> survivors = personHelper.getSurvivors(sortedPeople, true);
        ArrayList<Person> casualties = personHelper.getSurvivors(sortedPeople, false);

        // Avg age
        double totalYears = personHelper.totalAges(survivors);
        double averageAge = totalYears / (personHelper.filterForAgeData(survivors).size());
        System.out.println("\nAverage age of those that survived: " + intFormat.format(averageAge));

        totalYears = personHelper.totalAges(casualties);
        averageAge = totalYears / (personHelper.filterForAgeData(casualties).size());
        System.out.println("Average age of those that died: " + intFormat.format(averageAge));

        // Sex
        int maleCount = personHelper.totalBySex(survivors, true);
        int femaleCount = personHelper.totalBySex(survivors, false);
        System.out.println("\nOf those that survived, " + maleCount + " were male and " + femaleCount + " were female.");

        maleCount = personHelper.totalBySex(casualties, true);
        femaleCount = personHelper.totalBySex(casualties, false);
        System.out.println("Of those that died, " + maleCount + " were male and " + femaleCount + " were female.");

        // TODO: Figure out how to present this.
        System.out.println("Thus some statistic about likelihood of death for male/female");

        // Avg fare
        System.out.println("\nAverage fare for those that survived: $" + twoDec.format(personHelper.averageFare(survivors)));
        System.out.println("Average fare for those that died: $" + twoDec.format(personHelper.averageFare(casualties)));

        // Avg survival rate of persons in families
        double familySurvivors = familyHelper.getSurvivors(families).size();
        System.out.println("Average survival rate for people traveling with family: " + familySurvivors / totalFamilyMembers);
        
        // Avg survival rate of persons
        double survivorCount = survivors.size();
        System.out.println("\nAverage survival rate for all people: " + percent.format(survivorCount / sortedPeople.size()));

        // Avg survival rate and fare by port


        String[] ports = new String[]{"C", "Q", "S"};
        for(String portCode : ports){
            ArrayList<Person> portSurvivors = personHelper.getPeopleByPortCode(survivors, portCode);
            ArrayList<Person> portCasualties = personHelper.getPeopleByPortCode(casualties, portCode);
            double portTotal = personHelper.getPeopleByPortCode(sortedPeople, portCode).size();

            outputSurvivalData(portTotal, portSurvivors.size(), portCode);
            outputAverageSurvivalFare(portCode, portSurvivors);
            outputAverageCasualtyFare(portCode, portCasualties);
        }

        System.out.println("\n============================ Analysis complete! ============================\n");

    }

    static void outputSurvivalData(double totalCount, double survivorCount, String portCode) throws Exception {
        System.out.println("\n" + intFormat.format(totalCount) + " embarked from " + port(portCode) + ", but only " +
                intFormat.format(survivorCount) + " survived ( " + percent.format(survivorCount / totalCount) + " ).");
    }

    static void outputAverageSurvivalFare(String portCode, ArrayList<Person> survivors) throws Exception {
        System.out.println("The " + port(portCode) + " survivors paid an average fare of $" + twoDec.format(personHelper.averageFare(survivors)) + ".");
    }

    static void outputAverageCasualtyFare(String portCode, ArrayList<Person> casualties) throws Exception {
        System.out.println("However the " + port(portCode) + " casualties paid an average fare of $" + twoDec.format(personHelper.averageFare(casualties)) + ".");
    }

    static String port(String portCode) throws Exception {
        switch (portCode) {
            case "C":
                return "Cherbourg";
            case "Q":
                return "Queenstown";
            case "S":
                return "Southampton";
            case "M":
                return "Port Missing";
            default:
                throw new Exception("Unsupported port code " + portCode + " found.");
        }
    }
}
