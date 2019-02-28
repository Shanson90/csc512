import org.omg.CORBA.portable.ApplicationException;

public class Payroll {

    public int[] employeeId = new int[]{5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489};
    private int[] hours = new int[7];
    private double[] payRate = new double[7];
    private double[] wages = new double[7];

    public double getHours(int eId) throws Exception{
        int employeeIndex = findEmployeeIndex(eId);
        return hours[employeeIndex];
    }

    public void setHours(int eId, int hrs) throws Exception{
        if(hrs < 0){
            throw new Exception("Hours cannot be negative.");
        }

        int employeeIndex = findEmployeeIndex(eId);
        hours[employeeIndex] = hrs;
    }

    public double getPayRate(int eId) throws Exception{
        int employeeIndex = findEmployeeIndex(eId);
        return payRate[employeeIndex];
    }

    public void setPayRate(int eId, double rate) throws Exception{
        if(rate < 6.00){
            throw new Exception("Pay rate is below minimum wage!");
        }
        int employeeIndex = findEmployeeIndex(eId);
        payRate[employeeIndex] = rate;
    }

    public double getWages(int eId) throws Exception {
        int employeeIndex = findEmployeeIndex(eId);
        return wages[employeeIndex];
    }

    public void setWages(){
        for (int i = 0; i < employeeId.length; i++) {
            wages[i] = hours[i] * payRate[i];
        }
    }

    private int findEmployeeIndex(int eId) throws Exception{
        for(int i = 0; i < employeeId.length; i++){
            if(employeeId[i] == eId){
                return i;
            }
        }
        throw new Exception("Employee not found");
    }
}
