public class TFquestion extends Question {
    private boolean answer;

    TFquestion(String question, boolean answer) {
        this.answer = answer;
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TFquestion that = (TFquestion) o;
        return answer == that.answer && this.question.equals(that.question);
    }

}
