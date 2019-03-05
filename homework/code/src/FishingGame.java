import java.util.Scanner;

public class FishingGame {

    private static Scanner keyboard = new Scanner(System.in);
    private static String[] items = new String[]{"dirty old shoe", "big bass", "huge catfish", "frog", "carp", "gar"};
    private static int[] pointValues = new int[]{0, 5, 7, 2, 0, -1};
    private static int points = 0;

    public static void main(String[] args){
        boolean keepFishing = true;
        Die die = new Die(6);

        while(keepFishing){
            die.roll();
            int itemIndex = die.getValue() - 1;

            System.out.println("You caught a " + items[itemIndex] + ".");

            System.out.println("You get " + pointValues[itemIndex] + " points.");
            points += pointValues[itemIndex];

            System.out.println("Total points: " + points + " points.");
            System.out.println();

            System.out.println("Cast your line again?");
            System.out.println("(Enter 'y' to play again)");
            keepFishing = keyboard.next().toLowerCase().equals("y");
        }
    }
}
