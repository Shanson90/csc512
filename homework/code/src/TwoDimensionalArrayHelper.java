public class TwoDimensionalArrayHelper {
    
    public static void main(String[] args){
        int[][] multiDim = new int[][]{
                { 1, 2, 8, 5, 0, 3,  18, 10, 100, -100 },
                { 2, 3, 8, 4, 0, 6,  21, 20, 200, -110 },
                { 3, 4, 8, 3, 0, 9,  24, 30, 300, -120 },
                { 4, 5, 8, 2, 0, 12, 27, 40, 400, -130 },
                { 5, 1, 8, 1, 0, 15, 30, 50, 500, -140 }
        };
        System.out.println("Grand Total:   " + getTotal(multiDim));
        System.out.println("Grand Average: " + getAverage(multiDim));

        for(int i = 0; i < multiDim.length; i++){
            System.out.println("\nRow    " + (i + 1) + " Total: " + getRowTotal(multiDim, i));
            System.out.println("Column " + (i + 1) + " Total: " + getColumnTotal(multiDim, i));
            System.out.println("Row    " + (i + 1) + " Max  : " + getHighestInRow(multiDim, i));
            System.out.println("Row    " + (i + 1) + " Min  : " + getLowestInRow(multiDim, i));
        }
        
        
    }

    public static int getTotal(int[][] towDimAry){
        int result = 0;
        for(int i = 0; i < towDimAry.length; i++){
            result += getRowTotal(towDimAry, i);
        }
        return result;
    }

    public static int getAverage(int[][] twoDimAry){
        int count = 0;
        for(int i = 0; i < twoDimAry.length; i++){
            count += twoDimAry[i].length;
        }
        return getTotal(twoDimAry) / count;
    }

    public static int getRowTotal(int[][] twoDimAry, int row){
        int result = 0;
        for(int i = 0; i < twoDimAry[row].length; i++){
            result += twoDimAry[row][i];
        }
        return result;
    }

    public static int getColumnTotal(int[][] twoDimAry, int col){
        int result = 0;
        for(int i = 0; i < twoDimAry.length; i++){
            result += twoDimAry[i][col];
        }
        return result;
    }

    public static int getHighestInRow(int[][] twoDimAry, int row){
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < twoDimAry[row].length; i++){
            if(twoDimAry[row][i] > result){
                result = twoDimAry[row][i];
            }
        }
        return result;
    }

    public static int getLowestInRow(int[][] twoDimAry, int row){
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < twoDimAry[row].length; i++){
            if(twoDimAry[row][i] < result){
                result = twoDimAry[row][i];
            }
        }
        return result;
    }
}
