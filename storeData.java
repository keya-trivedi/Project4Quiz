import java.io.*;
import java.util.ArrayList;

public class StoreData {

    //https://examples.javacodegeeks.com/core-java/io/fileoutputstream/how-to-write-an-object-to-file-in-java/

    //send course arraylist to CourseData.txt in the memory
    public void storeCourseData(ArrayList<Course> courses) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("CourseData.txt"))) {
            for (int i = 0; i < courses.size(); i++) {
                objectOutputStream.writeObject(courses.get(i));
                objectOutputStream.flush();
            }
            objectOutputStream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }




    //https://examples.javacodegeeks.com/core-java/io/file/how-to-read-an-object-from-file-in-java/

    //get course arraylist to CourseData.txt
    public getCourseData() {
        ArrayList<Course> courses = new ArrayList<Course>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("CourseData.txt"))) {
            Course courseRead = (Course) objectInputStream.readObject();

            while(courseRead != null) {
                courses.add(courseRead);
                Read = (Course) objectInputStream.readObject();
            }

            objectInputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return courses;

    }


}
