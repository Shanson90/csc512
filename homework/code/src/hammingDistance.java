public class hammingDistance {

    public static int calculate(int x, int y){
        String hamString = Integer.toBinaryString(x ^ y);
        int hamDist = 0;

        for(int i = 0; i < hamString.length(); i++)
        {
            if (hamString.substring(i, i + 1).equals("1")){
                hamDist++;
            }
        }

        return hamDist;
    }
}
