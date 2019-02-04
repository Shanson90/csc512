import java.util.Scanner;

public class Weight {

    public static void main(){

        Scanner scanner = new Scanner(System.in);

        String massInput = scanner.nextLine();

        double mass = Double.parseDouble(massInput);

        double weight = mass * 9.8;

        if (weight > 1000.0){
            System.out.println("Too heavy!");
        }

        if (weight < 10.0){
            System.out.println("Too light!");
        }

        System.out.println(weight);
        System.exit(0);
    }

}
