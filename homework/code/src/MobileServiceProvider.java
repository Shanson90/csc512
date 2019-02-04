import java.util.Scanner;

public class MobileServiceProvider {
    
    public static void main(String[] args){
        System.out.println("Please enter which package you have. (A, B, or C)");
        Scanner keyboard = new Scanner(System.in);
        
        String pack =  keyboard.nextLine().toLowerCase();

        if(!(pack.equals("a") || pack.equals("b") || pack.equals("c"))){
            System.out.println("Invalid package entered. Please try again.");
            System.exit(0);
        }

        Integer mins;
        Double total = 0.0;

        switch (pack){
            case "c": total = calcC();
                break;
            case "a": mins = getMins();
                total = calcA(mins);
                break;
            case "b": mins = getMins();
                total = calcB(mins);
                break;
        }

        System.out.println("Your total charge is " + total);
    }

    private static Double calcC(){
        return 69.99;
    }

    private static Integer getMins(){
        System.out.println("Please enter the number of minutes used\n(round up to nearest whole number)");
        Scanner keyboard = new Scanner(System.in);
        return Integer.parseInt(keyboard.nextLine());
    }

    private static Double calcA(Integer minutesUsed){
        return standardPlan(39.99, 450, minutesUsed, 0.45);
    }

    private static Double calcB(Integer minutesUsed){
        return standardPlan(59.99, 900, minutesUsed, 0.40);
    }

    private static Double standardPlan(Double baseCost, Integer maxMins, Integer minutesUsed, Double costPerMin){
        if(minutesUsed <= maxMins){
            return baseCost;
        }else{
            return ((minutesUsed - maxMins) * costPerMin) + baseCost;
        }
    }


}
