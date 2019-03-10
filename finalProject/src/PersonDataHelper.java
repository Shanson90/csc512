import java.util.ArrayList;

public class PersonDataHelper {


    double totalFares(ArrayList<Person> people){
        double total = 0;
        for(int i = 0; i < people.size(); i++){
            total += people.get(i).getFare();
        }
        return total;
    }

    ArrayList<Person> getSurvivors(ArrayList<Person> people, boolean survived){
        ArrayList<Person> result = new ArrayList<>();

        for(int i = 0; i < people.size(); i++){
            if(people.get(i).getSurvival() == survived){
                result.add(people.get(i));
            }
        }

        return result;
    }

    int totalAges(ArrayList<Person> people){
        int total = 0;
        for(int i = 0; i < people.size(); i++){
            total += people.get(i).getAge();
        }
        return total;
    }

    int totalBySex(ArrayList<Person> people, Boolean isMale){
        int total = 0;
        for(int i = 0; i < people.size(); i++){
            if(people.get(i).getSex() == isMale){
                total++;
            }
        }
        return total;
    }

    ArrayList<Person> filterForAgeData(ArrayList<Person> people){
        ArrayList<Person> result = new ArrayList<>();
        for(int i = 0; i < people.size(); i++){
            if(people.get(i).getAge() > 0){
                result.add(people.get(i));
            }
        }
        return result;
    }

    ArrayList<Person> getPeopleByPortCode(ArrayList<Person> people, String portCode){
        ArrayList<Person> matches = new ArrayList<>();
        for(int i = 0; i < people.size(); i++){
            if(people.get(i).getPortCode().equals(portCode)){
                matches.add(people.get(i));
            }
        }
        return matches;
    }
}
