import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PayrollMain {
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        Payroll payroll = new Payroll();

        getData(payroll);
        payroll.setWages();
        showReport(payroll);
    }

    private static void getData(Payroll payroll) throws Exception {
        for(int empId : payroll.employeeId){
            System.out.println("\nEmployee ID: " + empId);

            System.out.println("Hours?");
            int hrs = Integer.parseInt(keyboard.readLine());
            payroll.setHours(empId, hrs);

            System.out.println("Rate of Pay?");
            double rate = Double.parseDouble(keyboard.readLine());
            payroll.setPayRate(empId, rate);
        }
    }

    private static void showReport(Payroll payroll) throws Exception {
        System.out.println("\nEmployee ID  |  Gross Wages");
        System.out.println("-------------------------");

        for(int empId : payroll.employeeId){
            System.out.println(empId + "      |  " + payroll.getWages(empId));
        }
    }
}
