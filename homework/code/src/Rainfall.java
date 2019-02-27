public class Rainfall {

    private double[] monthlyRainfallAmounts;
    public static String[] monthNames = new String[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    public Rainfall(double[] rainfallAmounts){
        monthlyRainfallAmounts = rainfallAmounts;
    }

    public String lowestMonth(){
        double min = Double.MAX_VALUE;
        int month = 0;
        for(int i = 0; i < 12; i++){
            if(monthlyRainfallAmounts[i] < min){
                min = monthlyRainfallAmounts[i];
                month = i;
            }
        }
        return monthNames[month];
    }

    public String highestMonth(){
        double max = Double.MIN_VALUE;
        int month = 0;
        for(int i = 0; i < 12; i++){
            if(monthlyRainfallAmounts[i] > max){
                max = monthlyRainfallAmounts[i];
                month = i;
            }
        }
        return monthNames[month];
    }

    public double annualRainfall(){
        double total = 0.0;
        for(double monthAmount : monthlyRainfallAmounts){
            total += monthAmount;
        }
        return total;
    }

    public double averageRainfall(){
        double average = 0.0;
        for(double monthAmount : monthlyRainfallAmounts){
            average += monthAmount;
        }
        return average / 12;
    }


}
