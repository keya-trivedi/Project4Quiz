import java.io.*;
import java.util.ArrayList;

public class StoreData {
    private ArrayList<Student> studentArrayList;
    private ArrayList<Teacher> teacherArrayList;
    private ArrayList<Quiz> quizArrayList;

    //https://examples.javacodegeeks.com/core-java/io/fileoutputstream/how-to-write-an-object-to-file-in-java/

    //send quiz arraylist to QuizData.txt in the memory
    public void storeQuizData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("QuizData.txt"))) {
            for (int i = 0; i < quizArrayList.size(); i++) {
                objectOutputStream.writeObject(quizArrayList.get(i));
                objectOutputStream.flush();
            }
            objectOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //send teacher arraylist to TeacherData.txt in the memory
    public void storeTeacherData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("TeacherData.txt"))) {
            for (int i = 0; i < teacherArrayList.size(); i++) {
                objectOutputStream.writeObject(teacherArrayList.get(i));
                objectOutputStream.flush();
            }
            objectOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //send teacher arraylist to StudentData.txt in the memory
    public void storeStudentData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("StudentData.txt"))) {
            for (int i = 0; i < studentArrayList.size(); i++) {
                objectOutputStream.writeObject(studentArrayList.get(i));
                objectOutputStream.flush();
            }
            objectOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }




    //https://examples.javacodegeeks.com/core-java/io/file/how-to-read-an-object-from-file-in-java/

    //get quiz arraylist to QuizData.txt
    public void getQuizData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("QuizData.txt"))) {
            Quiz quizRead = (Quiz) objectInputStream.readObject();

            while(quizRead != null) {
                quizArrayList.add(quizRead);
                quizRead = (Quiz) objectInputStream.readObject();
            }

            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //get teacher arraylist to TeacherData.txt
    public void getTeacherData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TeacherData.txt"))) {
            Teacher teacherRead = (Teacher) objectInputStream.readObject();

            while(teacherRead != null) {
                teacherArrayList.add(teacherRead);
                teacherRead = (Teacher) objectInputStream.readObject();
            }

            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //get student arraylist to TeacherData.txt
    public void getStudentData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("StudentData.txt"))) {
            Student studentRead = (Student) objectInputStream.readObject();

            while(studentRead != null) {
                studentArrayList.add(studentRead);
                studentRead = (Student) objectInputStream.readObject();
            }

            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
