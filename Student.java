public class Student extends User {

    public Student(String username, String password) {
        super(username, password);
    }

    public boolean isTeacher() {
        return false;
    }

}