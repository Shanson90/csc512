import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelfDividingNumber {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter beginning of range:\n");
        String begString = keyboard.nextLine();

        System.out.println("Enter end of range:\n");
        String endString = keyboard.nextLine();

        int begin = Integer.parseInt(begString);
        int end = Integer.parseInt(endString);

        List<Integer> selfDividers = findInRange(begin, end);
        System.out.println(selfDividers);
    }

    public static List<Integer> findInRange(int begin, int end){
        List<Integer> selfDividers = new ArrayList<>();

        for (int i = 0; i <= end - begin; i++) {
            if (isSelfDivisible(begin + i)){
                selfDividers.add(begin + i);
            }
        }
        return selfDividers;
    }

    private static boolean isSelfDivisible(int num){
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            int divisor = Integer.parseInt(strNum.substring(i, i + 1));

            if ( (divisor == 0) || ((num % divisor) != 0) ){
                return false;
            }
        }
        return true;
    }

    private static boolean isSelfDivisibleNoString(int num){
        if (num < 10){
            return true;
        }else if(num < 100){

        }else if(num < 1000){

        }else if(num < 10000){

        }
        return true;
    }
}