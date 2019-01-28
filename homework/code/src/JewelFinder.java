

public class JewelFinder {
    public static int findJewels(String jewel, String stones) {
        int jewelCount = 0;
        for (int i = 0; i < stones.length(); i++) {
            if(i + jewel.length() > stones.length()){
                return jewelCount;
            }

            String potentialJewel = stones.substring(i, i + jewel.length());
            if (potentialJewel.equals(jewel)) {
                jewelCount++;
            }
        }
        return jewelCount;
    }
}