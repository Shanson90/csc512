import java.util.Arrays;
import java.util.Scanner;

public class SortedNames {

    public static void main(String[] args){
        System.out.println("Type three names, pressing enter after each one.");
        Scanner keyboard = new Scanner(System.in);

        String name1 = keyboard.nextLine();
        String name2 = keyboard.nextLine();
        String name3 = keyboard.nextLine();

        String[] names = new String[] {name1, name2, name3};
        Arrays.sort(names);

        for(int i = 0; i < names.length; i++){
            System.out.println(" - " + names[i]);
        }
    }
}
