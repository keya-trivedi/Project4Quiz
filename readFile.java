import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {

    public void main(String[] args) throws FileNotFoundException {
        String fileName;
        String title;//title of the quiz
        String questionTile; //The question string
        String[] choices;//choices for question (5 choices)
        String answerString;//Answer before processing
        String answer;//Answer of the question

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the file name");
        fileName = scanner.nextLine();



        ArrayList<String> fileArraylist = new ArrayList<>();
        ArrayList<String> choicesArraylist = new ArrayList<>();

        File f = new File(fileName);
        FileReader fr = new FileReader(f);
        BufferedReader bfr = new BufferedReader(fr);

        try {
            String line;

            line = bfr.readLine();
            title = line;

            line = bfr.readLine();
            while (line != null) {
                fileArraylist.add(line);
                line = bfr.readLine();
            }


            for (int i = 0; i < fileArraylist.size(); i++) {
                String fileString = fileArraylist.get(i);
                while ((!(fileString.contains("Answer: ")) && fileString.length() != 9)) {
                    if (fileString.contains("Question: ")) {
                        i++;
                        questionTile = fileString;
                        //TODO setter

                    } else if ((fileString.contains("Answer: ")) && (fileString.length() != 9)) {
                        i++;
                        answerString = fileString;
                        answer = answerString.substring(8, answerString.length());
                        //TODO setter

                    } else {
                        i++;
                        choicesArraylist.add(fileString);
                    }
                    fileString = fileArraylist.get(i);
                }

                choices = choicesArraylist.toArray(new String[0]);
                //TODO setter

                //TODO unsure
                if ((line.contains("Answer: ")) && (line.length() != 9)) {
                    i++;
                    answerString = fileString;
                    answer = answerString.substring(8, answerString.length());
                    //setter
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }











    
}
