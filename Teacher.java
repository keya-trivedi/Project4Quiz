public class Teacher extends User {

    Teacher(String username, String password) {
        super(username, password);
    }

    public boolean isTeacher() {
        return true;
    }

}