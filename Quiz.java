import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public void deleteQuestion (int index) {
        questions.remove(index);
    }

    public void setQuestion (int index, Question q) {
        questions.set(index, q);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(quizName, quiz.quizName);
    }

    public String getQuizName() {
        return quizName;
    }

    public static Quiz fromFile(String fileName) {
        String line;
        ArrayList<String> attribs = new ArrayList<>();

        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();

            while (line != null) {
                attribs.add(line);

                String[] attributes = line.split(",");

                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Quiz quiz = new Quiz(attribs.get(0));

        int index = 1;
        while(index < attribs.size()) {
            if(attribs.get(index).equals("MC")) {
                quiz.addQuestion(new MCquestion(attribs.get(++index), attribs.get(++index), attribs.get(++index), attribs.get(++index), attribs.get(++index), Integer.parseInt(attribs.get(++index))));
            } else if(attribs.get(index).equals("FB")) {
                quiz.addQuestion(new FillBlankQuestion(attribs.get(++index), attribs.get(++index)));
            } else if(attribs.get(index).equals("TF")) {
                quiz.addQuestion(new TFquestion(attribs.get(++index), Boolean.parseBoolean(attribs.get(++index))));
            }

        }
        return quiz;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < questions.size(); i++) {
            str += String.format("%d.%s%n", i + 1, questions.get(i).getQuestion());
        }
        return str;
    }
}
