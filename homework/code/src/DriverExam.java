public class DriverExam {

    public int examLength = 20;
    public char[] studentAnswers = new char[20];
    private char[] correctAnswers = new char[]{
            'B','D','A','A','C','A','B','A','C','D',
            'B','C','D','A','D','C','C','D','D','A'
    };
    private int passingScore = 15;
    private int numCorrect = 0;
    private String incompleteTestErrMsg = "Did not receive answer for all 20 questions.";

    public void addStudentAnswer(int question, char answer) throws Exception {
        if(question > 20 || !(answer == 'A' || answer == 'B' || answer == 'C' || answer == 'D')){
            throw new Exception("Only A B C or D accepted as answers.");
        }
        studentAnswers[question] = answer;
        if(answer == correctAnswers[question]){
            numCorrect++;
        }
    }

    public boolean passed() throws Exception {
        if(studentAnswers.length < 20){
            throw new Exception(incompleteTestErrMsg);
        }
        return numCorrect >= passingScore;
    }

    public int totalCorrect(){
        return numCorrect;
    }

    public int[] questionsMissed(){
        int[] missed = new int[20];
        for(int i = 0; i < studentAnswers.length; i++){
            if(studentAnswers[i] != correctAnswers[i]){
                missed[i] = i + 1;
            }else{missed[i] = 0;}
        }
        return missed;
    }


}
