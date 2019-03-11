import java.util.ArrayList;

class FamilyDataHelper {


    double totalFares(ArrayList<Family> families){
        double fares = 0;
        for(Family family : families){
            fares += family.totalFare();
        }
        return fares;
    }

    int personCount(ArrayList<Family> families){
        int count = 0;
        for(Family family : families){
            count += family.getSize();
        }
        return count;
    }

    ArrayList<Person> getSurvivors(ArrayList<Family> families){
        ArrayList<Person> survivors = new ArrayList<>();
        for(Family family : families){
            survivors.addAll(family.getSurvivors());
        }
        return survivors;
    }

}
