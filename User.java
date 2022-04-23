
import java.io.*;
import java.util.ArrayList;

public class User implements Serializable{
    protected String username;
    protected String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object o) {
        User that = (User) o;
        return this.username.equals(that.username) && this.password.equals((that.password));
    }

    public void toFile(String fileName) {
        File f = new File(fileName);
        String descriptor;
        if (this instanceof Teacher) {
            descriptor = "Teacher";
        } else {
            descriptor = "Student";
        }

        try {
            FileWriter fwr = new FileWriter(f, true);
            fwr.append(String.format("%s,%s,%s\n",username, password, descriptor));
            fwr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static final ArrayList<User> readFromFile(String filename) {
        ArrayList<User> users = new ArrayList<User>();
        String line;
        try {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");

                if (attributes[2].equals("Teacher")) {
                    users.add(new Teacher(attributes[0], attributes[1]));
                } else if (attributes[2].equals("Student")) {
                    users.add(new Student(attributes[0], attributes[1]));
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }


}
