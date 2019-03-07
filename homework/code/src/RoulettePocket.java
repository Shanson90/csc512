public class RoulettePocket {

    private int pocket;
    private String color;

    public RoulettePocket(int pocketNum) throws Exception{
        pocket = pocketNum;
        if(pocket < 0 || pocket > 36){ throw new Exception("Pocket must be between 0 and 36"); }
        if(pocket == 0){
            color = "green";
        } else if(pocket <= 10 || (pocket >= 19 && pocket < 28 )){
            color = oddRed(pocket);
        } else if(pocket <= 18 || pocket >= 29){
            color = oddBlack(pocket);
        }
    }

    public String getPocketColor(){
        return color;
    }

    private String oddRed(int num){
        if(num % 2 == 0){
            return "black";
        }else {
            return "red";
        }
    }

    private String oddBlack(int num){
        if(num % 2 == 0){
            return "red";
        }else {
            return "black";
        }
    }
}
