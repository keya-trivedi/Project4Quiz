public class AnsweredQuestion {
    private Question question;
    private String answer;
    private boolean correct;

    public AnsweredQuestion(Question question, String answer, boolean correct) {
        this.question = question;
        this.answer = answer;
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String toString() {
        String correctPhrase;
        if (this.correct) {
            correctPhrase = "Correct!";
        } else {
            correctPhrase = "Wrong!";
        }
        return String.format("Question: %s. They answered %s. %s", this.question.getQuestion(), this.answer, correctPhrase);
    }

}