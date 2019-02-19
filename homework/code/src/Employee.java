class Employee {

    String name;
    int idNumber;
    String department;
    String position;

    Employee(String eName, int eIdNumber, String eDepartment, String ePosition){
        name = eName;
        idNumber = eIdNumber;
        department = eDepartment;
        position = ePosition;
    }

    Employee(String eName, int eIdNumber){
        name = eName;
        idNumber = eIdNumber;
        department = "";
        position = "";
    }

    Employee(){
        name = "";
        idNumber = 0;
        department = "";
        position = "";
    }
}
