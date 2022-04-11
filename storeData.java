import java.io.*;
import java.util.ArrayList;

public class StoreData {
    private ArrayList<Course> courseArrayList;

    //https://examples.javacodegeeks.com/core-java/io/fileoutputstream/how-to-write-an-object-to-file-in-java/

    //send course arraylist to CourseData.txt in the memory
    public void storeCourseData() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("CourseData.txt"))) {
            for (int i = 0; i < courseArrayList.size(); i++) {
                objectOutputStream.writeObject(courseArrayList.get(i));
                objectOutputStream.flush();
            }
            objectOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }




    //https://examples.javacodegeeks.com/core-java/io/file/how-to-read-an-object-from-file-in-java/

    //get course arraylist to CourseData.txt
    public void getCourseData() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("CourseData.txt"))) {
            Course courseRead = (Course) objectInputStream.readObject();

            while(courseRead != null) {
                courseArrayList.add(courseRead);
                Read = (Course) objectInputStream.readObject();
            }

            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}
