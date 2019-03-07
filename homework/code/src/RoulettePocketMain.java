import java.util.Scanner;

public class RoulettePocketMain {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("You really shouldn't play roulette... You'll go broke.");
        System.out.println("Until then...");
        System.out.println("Enter the Pocket Number");

        int pocketNumber = keyboard.nextInt();

        RoulettePocket roul = new RoulettePocket(pocketNumber);
        System.out.println("The color of the pocket is " + roul.getPocketColor());
    }
}
