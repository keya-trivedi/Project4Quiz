public abstract class Question {
    protected String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public abstract boolean equals(Object o);


}