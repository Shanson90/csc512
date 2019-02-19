public class EmployeeBuilder {
    public static void main(String[] args){
        Employee[] employees = new Employee[3];
        employees[0] = new Employee(
                "Susan Meyers",
                47899,
                "Accounting",
                "Vice President"
        );

        employees[1] = new Employee(
                "Mark Jones",
                39119,
                "IT",
                "Programmer"
        );

        employees[2] = new Employee(
                "Joy Rogers",
                81774,
                "Manufacturing",
                "Engineer"
        );

        for (Employee employee : employees) {
            System.out.println(employee.name + " (id: " + employee.idNumber + ")");
            System.out.println("Department: " + employee.department);
            System.out.println("Position: " + employee.position);
            System.out.println(" ");
        }
    }
}
