import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Runnable {
    public static int CREATE_STUDENT = 0;
    public static int CREATE_TEACHER = 1;
    public static int SIGN_IN = 2;
    public static int DELETE_USER = 3;

    private static ArrayList<User> users = User.readFromFile("Usersinfo.txt");
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
                    case 0: //create a student

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
                    case 1:
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
                        break;


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

