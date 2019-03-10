import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

    static final DecimalFormat twoDec = new DecimalFormat("0.00");
    static final DecimalFormat intFormat = new DecimalFormat("0");
    static final DecimalFormat percent = new DecimalFormat("0%");

    public static void main(String[] args) throws Exception{
        // Import data into Person Classes
        PersonImporter importer = new PersonImporter("titanic.csv");
        importer.parsePeople();
        importer.sortByLastName();
        ArrayList<Person> sortedPeople = importer.getPeople();

        // Relate persons in Family Classes
        FamilyFinder famFinder = new FamilyFinder();
        ArrayList<Family> families = famFinder.findAll(sortedPeople);

        // helpers to aggregate specific data on arrays of Persons/Families
        PersonDataHelper personHelper = new PersonDataHelper();
        FamilyDataHelper familyHelper = new FamilyDataHelper();

        // Avg cost per person for all persons
        double totalFares = personHelper.totalFares(sortedPeople);
        double averageFare = totalFares / sortedPeople.size();
        System.out.println("Average fare per person:  $" + twoDec.format(averageFare));

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
        totalFares = personHelper.totalFares(survivors);
        double averageSurvivorFare = totalFares / survivors.size();
        System.out.println("\nAverage fare for those that survived: $" + twoDec.format(averageSurvivorFare));

        totalFares = personHelper.totalFares(casualties);
        averageFare = totalFares / survivors.size();
        System.out.println("Average fare for those that died: $" + twoDec.format(averageFare));

        // Avg survival rate of persons in families
        double familySurvivors = familyHelper.getSurvivors(families).size();
        System.out.println("Average survival rate for people traveling with family: " + familySurvivors / totalFamilyMembers);
        
        // Avg survival rate of persons
        double survivorCount = survivors.size();
        System.out.println("\nAverage survival rate for all people: " + percent.format(survivorCount / sortedPeople.size()));

        // Avg survival rate by port
        double cherbourgSurvivors = personHelper.getPeopleByPortCode(survivors, "C").size();
        double cherbourgTotal = personHelper.getPeopleByPortCode(sortedPeople, "C").size();
        System.out.println(cherbourgTotal + " embarked from " + " Cherbourg, but only " +
                cherbourgSurvivors + " survived ( " + percent.format(cherbourgSurvivors / cherbourgTotal) + " ).");

        double queenstownSurvivors = personHelper.getPeopleByPortCode(survivors, "Q").size();
        double queenstownTotal = personHelper.getPeopleByPortCode(sortedPeople, "Q").size();
        System.out.println(queenstownTotal + " embarked from " + " Cherbourg, but only " +
                queenstownSurvivors + " survived ( " + percent.format(queenstownSurvivors / queenstownTotal) + " ).");

        double southamptonSurvivors = personHelper.getPeopleByPortCode(survivors, "S").size();
        double southamptonTotal = personHelper.getPeopleByPortCode(sortedPeople, "S").size();
        System.out.println(southamptonTotal + " embarked from " + " Cherbourg, but only " +
                southamptonSurvivors + " survived ( " + percent.format(southamptonSurvivors / southamptonTotal) + " ).");

        System.out.println("\n============================ Analysis complete! ============================\n");

    }
}
