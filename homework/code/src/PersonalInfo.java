import java.util.Scanner;

public class PersonalInfo {

    private static Scanner keyboard = new Scanner(System.in);
    private static String output;

    public static void main(){
        getName();
        getAddress();
        getPhone();
        getMajor();
        System.out.println(output);
    }

    public static void getName(){
        System.out.print("What is your name?");
        String name = keyboard.nextLine();
        output += name + "\n";
    }

    public static void getAddress(){
        System.out.print("What is your address?");
        String address = keyboard.nextLine();
        output += address + "\n";
    }

    public static void getPhone(){
        System.out.print("What is your phone number?");
        String phone = keyboard.nextLine();
        output += phone + "\n";
    }

    public static void getMajor(){
        System.out.print("What is/was your major (in college)?");
        String major = keyboard.nextLine();
        output += major + "\n";
    }
}
