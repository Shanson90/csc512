import java.util.ArrayList;

public class Family {

    private ArrayList<Person> members;
    private int size;

    Family(ArrayList<Person> familyMembers){
        members = familyMembers;
        size = familyMembers.size();
    }

    double totalFare(){
        double total = 0;
        for(int i = 0; i < members.size(); i++){
            total += members.get(i).getFare();
        }
        return total;
    }

    int getSize(){
        return size;
    }

    ArrayList<Person> getSurvivors(){
        ArrayList<Person> survivors = new ArrayList<>();
        for(Person member : members){
            if(member.getSurvival()){
                survivors.add(member);
            }
        }
        return survivors;
    }

}
