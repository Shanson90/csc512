import java.util.ArrayList;

public class Main {

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
        System.out.println("Average fare per person:  $" + averageFare);

        // Avg cost per person for persons in Families
        double totalFamilyFares = familyHelper.totalFares(families);
        double totalFamilyMembers = familyHelper.personCount(families);
        double averageFamilyMemberFare = totalFamilyFares / totalFamilyMembers;
        System.out.println("Average fare for those traveling with family:  $" + averageFamilyMemberFare);

        ArrayList<Person> survivors = personHelper.getSurvivors(sortedPeople, true);
        ArrayList<Person> casualties = personHelper.getSurvivors(sortedPeople, false);

        // Avg age
        double totalYears = personHelper.totalAges(survivors);
        double averageAge = totalYears / survivors.size();
        System.out.println("\nAverage age of those that survived: " + averageAge);

        totalYears = personHelper.totalAges(casualties);
        averageAge = totalYears / survivors.size();
        System.out.println("Average age of those that died: " + averageAge);

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
        System.out.println("\nAverage fare for those that survived: " + averageSurvivorFare);

        totalFares = personHelper.totalFares(casualties);
        averageFare = totalFares / survivors.size();
        System.out.println("Average fare for those that died: " + averageFare);

        // Avg survival rate of persons in families
        double familySurvivors = familyHelper.getSurvivors(families).size();
        System.out.println("Average survival rate for people traveling with family: " + familySurvivors / totalFamilyMembers);
        
        // Avg survival rate of persons
        double survivorCount = survivors.size();
        System.out.println("Average survival rate for all people: " + survivorCount / sortedPeople.size());

        // Avg survival rate by port
        double cherbourgSurvivors = personHelper.getPeopleByPortCode(survivors, 'C').size();
        double cherbourgTotal = personHelper.getPeopleByPortCode(sortedPeople, 'C').size();
        System.out.println(cherbourgTotal + " embarked from " + " Cherbourg, but only " +
                cherbourgSurvivors + " survived ( " + cherbourgSurvivors / cherbourgTotal + " ).");


        double queenstownSurvivors = personHelper.getPeopleByPortCode(survivors, 'Q').size();
        double queenstownTotal = personHelper.getPeopleByPortCode(sortedPeople, 'Q').size();
        System.out.println(queenstownTotal + " embarked from " + " Cherbourg, but only " +
                queenstownSurvivors + " survived ( " + queenstownSurvivors / queenstownTotal + " ).");

        double southamptonSurvivors = personHelper.getPeopleByPortCode(survivors, 'S').size();
        double southamptonTotal = personHelper.getPeopleByPortCode(sortedPeople, 'S').size();
        System.out.println(southamptonTotal + " embarked from " + " Cherbourg, but only " +
                southamptonSurvivors + " survived ( " + southamptonSurvivors / southamptonTotal + " ).");

    }
}
