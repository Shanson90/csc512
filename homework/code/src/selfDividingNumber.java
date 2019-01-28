import java.util.ArrayList;
import java.util.List;

public class selfDividingNumber {

    public static List<Integer> findInRange(int begin, int end){
        List<Integer> selfDividers = new ArrayList<>();

        for (int i = 0; i < end - begin + 1; i++) {
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
}
