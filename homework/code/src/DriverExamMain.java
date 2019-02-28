import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverExamMain {
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        DriverExam exam = new DriverExam();

        getAnswers(exam);
        showReport(exam);
    }

    private static void getAnswers(DriverExam test) throws Exception {
        for(int i = 0; i < test.examLength; i++){
            System.out.println("Question " + (i + 1) + " answer?");

            char answer = keyboard.readLine().charAt(0);
            test.addStudentAnswer(i, answer);
        }
    }

    private static void showReport(DriverExam test) throws Exception {
        if(test.passed()){
            System.out.println("Congratulations! You passed your driver exam!");
        }else{
            System.out.println("\nUnfortunately you failed your driver exam.");
        }
        System.out.println("\nYou got a total of " + test.totalCorrect() + " correct answers.");

        System.out.println("\nHere are the questions you missed:");
        System.out.println("\nQuestion | Your Answer ");
        int[] missed = test.questionsMissed();

        for(int i = 0; i < test.examLength; i++){
            String spacing = "       | ";
            if(missed[i] != 0){
                if(missed[i] < 10){
                    spacing = " " + spacing;
                }
                System.out.println(missed[i] + spacing + test.studentAnswers[i]);

            }
        }
    }
}
