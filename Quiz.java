import java.util.ArrayList;

public class Quiz {
    private String quizName;
    ArrayList<Question> questions;

    public Quiz(String quizName) {
        this.quizName = quizName;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int getQuestionCount() {
        return questions.size();
    }

    public boolean deleteQuestion (Question q) {

        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).equals(q)) {
                questions.remove(i); //FIXME, look into just passing the object into remove
                return true; //the question was removed
            }
        }
        return false; //the question was not in the quiz

    }