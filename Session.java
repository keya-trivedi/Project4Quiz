import java.util.Objects;

public class Session {
    private boolean loggedIn;
    private Course currentCourse;
    private User user;
    private int sessionNum;
    private Quiz currentQuiz;


    public Session(int sessionNum) {
        loggedIn = false;
        currentCourse = null;
        user = null;
        currentQuiz = null;
    }

    public Quiz getCurrentQuiz() {
        return currentQuiz;
    }

    public void setCurrentQuiz(Quiz currentQuiz) {
        this.currentQuiz = currentQuiz;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void logout() {
        loggedIn = false;
        currentCourse = null;
        currentQuiz = null;
        user = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return loggedIn == session.loggedIn && sessionNum == session.sessionNum && Objects.equals(currentCourse, session.currentCourse) && Objects.equals(user, session.user);
    }

