import java.util.ArrayList;
import java.util.Objects;

public class Quiz {
    private String quizName;
    ArrayList<Question> questions;

    public Quiz(String quizName) {
        this.quizName = quizName;
        this.questions = new ArrayList<Question>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(quizName, quiz.quizName);
    }

}
