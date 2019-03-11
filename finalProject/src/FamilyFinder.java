import java.util.ArrayList;

public class FamilyFinder {

    ArrayList<Family> findAll(ArrayList<Person> sortedPeople){
        // Pre-process to make array shorter and logic simpler
        ArrayList<Person> allPeopleInFamilies = eliminatePeopleWithoutFamily(sortedPeople);

        ArrayList<Family> families = new ArrayList<>();
        ArrayList<Person> members;

        for(int i = 0; i < allPeopleInFamilies.size(); i++){
            String lastName = allPeopleInFamilies.get(i).getLastName();
            members = findFamilyMembers(allPeopleInFamilies, lastName);
            if(members.size() > 1){
                families.add(new Family(members));
            }
        }

        return families;
    }

    private ArrayList<Person> eliminatePeopleWithoutFamily(ArrayList<Person> people){
        ArrayList<Person> peopleInFamilies = new ArrayList<>();
        for(Person person : people){
            if(person.getDiffGenFamily() > 0 || person.getSameGenFamily() > 0){
                peopleInFamilies.add(person);
            }
        }
        return peopleInFamilies;
    }

    private ArrayList<Person> findFamilyMembers(ArrayList<Person> people, String searchName){
        ArrayList<Person> matchingPeople = new ArrayList<>();

        for(Person person : people){
            if(person.getLastName().equals(searchName) && !person.getFamilyAssociation()){
                matchingPeople.add(person);
                person.setFamilyAssociation(true);
            }
        }
        return matchingPeople;
    }
}
