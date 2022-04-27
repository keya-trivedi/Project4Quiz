import java.io.*;
import java.net.*;

public class Client {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket socket = new Socket("127.0.0.1",4242);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        LoginScreen currentFrame = new LoginScreen(socket, pw, oos, ois);
        Utils.makeFrameFromTemplate(currentFrame, "Login");

    }
}