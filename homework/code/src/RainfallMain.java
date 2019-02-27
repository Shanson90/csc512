import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RainfallMain {

    public static void main(String[] args) throws IOException {
        double[] rainFallAmounts = new double[12];

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter rainfall amounts one at a time, pressing enter after each");

        for(int i = 0; i < 12; i++){
            System.out.println(Rainfall.monthNames[i] + " ?");
            rainFallAmounts[i] = Double.parseDouble(keyboard.readLine());
            if(rainFallAmounts[i] < 0.0){
                System.out.println("You can't have negative rainfall. Try again.");
                System.exit(0);
            }

        }

        Rainfall rainfall = new Rainfall(rainFallAmounts);

        System.out.println("Total rainfall for the year: " + rainfall.annualRainfall());
        System.out.println("Month with highest rainfall: " + rainfall.highestMonth());
        System.out.println("Month with lowest rainfall: " + rainfall.lowestMonth());
        System.out.println("Average monthly rainfall: " + rainfall.averageRainfall());
    }
}
