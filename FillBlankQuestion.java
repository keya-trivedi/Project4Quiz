
public class FillBlankQuestion extends Question{
    String answer;

    public FillBlankQuestion(String question, String answer) {
        super(question);
        this.answer = answer.toLowerCase();
    }

    public boolean check(String guess) {
        return guess.toLowerCase().equals(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}
