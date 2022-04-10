import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class QuizSubmission {
    private Date quizStart;
    private Date quizEnd;
    private ArrayList<Question> questionsAsked;
    private ArrayList<AnsweredQuestion> answeredQuestions;



    QuizSubmission(Quiz quiz, Scanner scanner) {
        quizStart = new Date();
        questionsAsked = new ArrayList<>(quiz.getQuestions());
        answeredQuestions = new ArrayList<>();

        Collections.shuffle(questionsAsked);

        int numCorrect = 0;
        for(int i = 0 ; i < questionsAsked.size(); i++) {
            AnsweredQuestion response = questionsAsked.get(i).getAnswer(scanner);
            if (response.isCorrect()) {
                numCorrect++;
            }
            answeredQuestions.add(response);
        }

        System.out.printf("You got a %d/%d on this quiz!\n", numCorrect, questionsAsked.size());

        quizEnd = new Date();
    }

}
