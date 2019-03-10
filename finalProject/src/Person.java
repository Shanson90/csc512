public class Person {

    private int id;
    private boolean survived;
    private int economicClass;
    private String fullName;
    private boolean isMale;
    private double age;
    private int sameGenFamilyCount;
    private int diffGenFamilyCount;
    private String ticket;
    private double fare;
    private String cabin;
    private String portCode;
    private String port;

    Person(int idNum){
        id = idNum;
    }

    void setSurvival(Boolean survival){
        survived = survival;
    }

    void setClass(int personClass){
        economicClass = personClass;
    }

    void setName(String name){
        fullName = name;
    }

    String getLastName(){
        String[] names = fullName.split(",");
        return names[0];
    }

    String getFirstName(){
        String[] names = fullName.split(",");
        return names[1];
    }

    void setSex(boolean male){
        isMale = male;
    }

    void setAge(double newAge){
        age = newAge;
    }

    void setSameGenFamily(int members){
        sameGenFamilyCount = members;
    }

    void setDiffGenFamily(int members){
        diffGenFamilyCount = members;
    }

    void setTicket(String newTicket){
        ticket = newTicket;
    }

    void setFare(double newFare){
        fare = newFare;
    }

    void setCabin(String newCabin){
        cabin = newCabin;
    }

    void setPort(String newPortCode) throws Exception{
        portCode = newPortCode;

        switch (newPortCode){
            case "C": port = "Cherbourg";
                break;
            case "Q": port = "Queenstown";
                break;
            case "S": port = "Southampton";
                break;
            default: throw new Exception("Unsupported port code " + portCode + " found.");
        }
    }

}
