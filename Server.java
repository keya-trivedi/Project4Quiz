
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.CheckedOutputStream;

public class Server implements Runnable {
    public static final int GET_COURSES_STR = -1;
    public static final int CREATE_STUDENT = 0;
    public static final int CREATE_TEACHER = 1;
    public static final int SIGN_IN = 2;
    public static final int MAKE_COURSE = 3;
    public static final int EDIT_COURSE = 4;
    public static final int DELETE_COURSE = 5;
    public static final int EDIT_USERNAME = 6;
    public static final int EDIT_PASSWORD = 7;
    public static final int LOGOUT = 8;
    public static final int DELETE_ACCOUNT = 9;







    private static ArrayList<User> users = User.readFromFile("Usersinfo.txt");
    private static ArrayList<Course> courses = new ArrayList<>(); //fixme
    private static ArrayList<Session> sessions = new ArrayList<Session>();
    private static int sessionNum = 0;

    Socket socket;
    Session session;

    public Server(Socket socket) {
        this.socket = socket;
        this.session = new Session(sessionNum++);

    }

    public void run() {
        System.out.printf("connection received from %s\n", socket);
        PrintWriter pw = null;
        //Scanner in = new Scanner(socket.getInputStream());
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        //Scanner in = new Scanner(socket.getInputStream());
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            pw = new PrintWriter(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!socket.isClosed()) {
            try {
                // socket open: make PrinterWriter and Scanner from it...

                // read from input, and echo output...

                int path = 0;
                try {
                    path = (Integer) ois.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                boolean completed = true;
                User proposedUser = null;
                switch (path) {
                    case CREATE_STUDENT: //create a student

                        try {
                            proposedUser = (User) ois.readObject();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                        for (User u : users) {
                            if (u.getUsername().equals(proposedUser.getUsername())) {
                                System.out.println("We lit");
                                oos.writeObject("Try another username, it is already taken");
                                oos.flush();
                                completed = false;
                                break;

                            }
                        }
                        if (completed) {
                            oos.writeObject("Success");
                            oos.flush();
                            session.setUser(new Student(proposedUser.getUsername(), proposedUser.getPassword()));
                            users.add(session.getUser()); //FIXME make student
                            session.setLoggedIn(true);
                        }
                        break;
                    case CREATE_TEACHER:
                        try {
                            proposedUser = (User) ois.readObject();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                        for (User u : users) {
                            if (u.getUsername().equals(proposedUser.getUsername())) {
                                System.out.println("We lit");
                                oos.writeObject("Try another username, it is already taken");
                                oos.flush();
                                completed = false;
                                break;

                            }
                        }
                        if (completed) {
                            oos.writeObject("Success");
                            oos.flush();
                            session.setUser(new Teacher(proposedUser.getUsername(), proposedUser.getPassword()));
                            users.add(session.getUser()); //FIXME make student
                            session.setLoggedIn(true);
                        }
                        break;
                    case 2:
                        try {
                            proposedUser = (User) ois.readObject();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        if (users.contains(proposedUser)) {
                            oos.writeObject("Success");
                            session.setLoggedIn(true);
                            session.setUser(users.get(users.indexOf(proposedUser)));
                        } else {
                            oos.writeObject("We could not find an account with that login info");
                        }
                        oos.flush();
                        break;
                    case EDIT_USERNAME:
                        try {
                            String newUsername = (String) ois.readObject();
                            if (newUsername.contains(",")) {
                                oos.writeObject("Usernames can not contain a comma");
                            } else {
                                session.getUser().setUsername(newUsername);
                                Utils.reWriterUserFile(users,"UsersInfo.txt");
                                oos.writeObject("Success");
                            }
                            oos.flush();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case EDIT_PASSWORD:
                        try {
                            String newPassword = (String) ois.readObject();
                            if (newPassword.contains(",")) {
                                oos.writeObject("Passwords can not contain a comma");
                            } else {
                                session.getUser().setPassword(newPassword);
                                Utils.reWriterUserFile(users,"UsersInfo.txt");
                                oos.writeObject("Success");
                            }
                            oos.flush();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;

                    case MAKE_COURSE:
                        try {
                            Course c = (Course) ois.readObject();
                            courses.add(c);
                            oos.writeObject("Success");

                        } catch (ClassNotFoundException e){
                            e.printStackTrace();
                        }
                        break;

                    case LOGOUT:
                        session.logout();
                        oos.writeObject("Success");
                        oos.flush();
                        break;
                    case DELETE_ACCOUNT:
                        users.remove(session.getUser());
                        Utils.reWriterUserFile(users, "Usersinfo.txt");
                        session.logout();
                        oos.writeObject("Success");
                        oos.flush();
                        break;
                    case GET_COURSES_STR:
                        if (courses.size() == 0) {
                            oos.writeObject("There are no courses made");
                            break;
                        }
                        oos.writeObject("Success");
                        ArrayList<String> courseListStr = new ArrayList<>();
                        for (int i = 0; i < courses.size(); i++) {
                            courseListStr.add(String.format("%d.%s %s%n", i + 1, courses.get(i).getCourseName(), courses.get(i).getCourseNumber()));
                        }
                        oos.writeObject(courseListStr);
                        break;
                    case DELETE_COURSE:
                        try {
                            int index = (int) ois.readObject();
                            courses.remove(index);
                            oos.writeObject("Success");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // input done, close connections...
        System.out.println("closing");
        pw.close();
        try {
            oos.close();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void main (String[] args) throws IOException {


            ServerSocket serverSocket = new ServerSocket(4242);
            System.out.printf("socket open, waiting for connections on %s\n",
                    serverSocket);

            // infinite server loop: accept connection,
            // spawn thread to handle...
            while (true) {
                Socket socket = serverSocket.accept();
                Server server = new Server(socket);
                new Thread(server).start();
            }


        }
}

