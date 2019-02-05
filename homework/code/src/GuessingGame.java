import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private static Scanner keyboard = new Scanner(System.in);
    private static int guessCount = 1;

    public static void main(String[] args){
        System.out.println("The Guessing Game!");


        Random randGen = new Random();
        Integer secretNumber = randGen.nextInt(10);
        System.out.println("Ok... I'm thinking of a number between 0 and 10.");
        System.out.println("Enter your first guess.");
        Integer guess = keyboard.nextInt();

        if(guess.equals(secretNumber)){
            System.out.println("Wow! First try!");
            System.exit(0);
        }else{ playUntilWin(guess, secretNumber); }


        System.out.println("You guessed it!\n" + "It took you " + guessCount + " guesses to guess the secret number " + secretNumber);
        if(guessCount > 11){
            System.out.println("You really aren't that smart... There were only 11 possibilities (0 through 10)");
        }
        System.exit(0);
    }

    private static void playUntilWin(Integer guess, Integer secretNumber){
        String feedback;
        while(!guess.equals(secretNumber)){
            if(guess > secretNumber){
                feedback = "high";
            }else{
                feedback = "low";
            }
            System.out.println("Too " + feedback + ", try again.");

            if(keyboard.hasNext()){
                guess = keyboard.nextInt();
                guessCount++;
            }
        }
    }
}
