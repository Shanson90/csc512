public class ShowCar {

    public static void main(String[] args){
        showCar("car", 2);
    }

    private static void showCar(String s, int position){
        System.out.println(s.charAt(position));
    }
}
