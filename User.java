import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
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


}
