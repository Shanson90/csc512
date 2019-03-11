public class Person {

    private int id;
    private boolean survived;
    private int economicClass;
    private String firstName;
    private String lastName;
    private boolean isMale;
    private double age;
    private int sameGenFamilyCount;
    private int diffGenFamilyCount;
    private String ticket;
    private double fare;
    private String cabin;
    private String portCode;
    private String port;
    private boolean inFamily;

    Person(int idNum) {
        id = idNum;
    }

    int getId(){
        return id;
    }

    boolean getSurvival() {
        return survived;
    }

    void setSurvival(Boolean survival) {
        survived = survival;
    }

    int getPassengerClass(){
        return economicClass;
    }

    void setPassengerClass(int personClass) {
        economicClass = personClass;
    }

    void setName(String name) {
        String[] splitNames = name.split(",");
        firstName = splitNames[1];
        lastName = splitNames[0];
    }

    String getLastName() {
        return lastName;
    }

    String getFirstName() {
        return firstName;
    }

    boolean getSex() {
        return isMale;
    }

    void setSex(boolean male) {
        isMale = male;
    }

    double getAge() {
        return age;
    }

    void setAge(double newAge) {
        age = newAge;
    }

    int getSameGenFamily(){
        return sameGenFamilyCount;
    }

    void setSameGenFamily(int members) {
        sameGenFamilyCount = members;
    }

    int getDiffGenFamily(){
        return diffGenFamilyCount;
    }

    void setDiffGenFamily(int members) {
        diffGenFamilyCount = members;
    }

    String getTicket(){
        return ticket;
    }

    void setTicket(String newTicket) {
        ticket = newTicket;
    }

    double getFare() {
        return fare;
    }

    void setFare(double newFare) {
        fare = newFare;
    }

    String getCabin(){
        return cabin;
    }

    void setCabin(String newCabin) {
        cabin = newCabin;
    }

    String getPort(){
        return port;
    }

    void setPort(String newPortCode) throws Exception {
        portCode = newPortCode;

        switch (newPortCode) {
            case "C":
                port = "Cherbourg";
                break;
            case "Q":
                port = "Queenstown";
                break;
            case "S":
                port = "Southampton";
                break;
            case "M":
                port = "Port Missing";
                break;
            default:
                throw new Exception("Unsupported port code " + portCode + " found.");
        }
    }

    String getPortCode() {
        return portCode;
    }

    void setFamilyAssociation(boolean isInFamily){
        inFamily = isInFamily;
    }

    boolean getFamilyAssociation(){
        return inFamily;
    }

}
