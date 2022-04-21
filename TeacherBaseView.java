import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class TeacherBaseView extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel prompt = new JLabel("WHAT DO YOU WANT TO DO?");
    JButton makeCourseButton = new JButton("MAKE COURSE");
    JButton editCourseButton = new JButton("EDIT COURSE");
    JButton deleteCourseButton = new JButton("EDIT COURSE");
    JButton logoutButton = new JButton("LOGOUT");
    JButton resetPassButton = new JButton("RESET PASSWORD");
    JButton resetNameButton = new JButton("RESET USERNAME");
    JButton delAccountButton = new JButton("DELETE ACCOUNT");

    Socket socket;
    PrintWriter pw;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    TeacherBaseView(Socket socket, PrintWriter pw, ObjectOutputStream oos, ObjectInputStream ois) {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.socket = socket;

        this.pw = pw;
        this.oos = oos;
        this.ois = ois;
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        prompt.setBounds(100, 150, 250, 30);
        makeCourseButton.setBounds(25, 220, 150, 30);
        editCourseButton.setBounds(175, 220, 150, 30);
        deleteCourseButton.setBounds(25, 290, 150, 30);
        resetNameButton.setBounds(175, 290, 150, 30);
        resetPassButton.setBounds(25, 360, 150, 30);
        logoutButton.setBounds(175, 360, 150, 30);
        delAccountButton.setBounds(25, 430, 175, 30);
    }

    public void addComponentsToContainer() {
        container.add(prompt);
        container.add(makeCourseButton);
        container.add(editCourseButton);
        container.add(deleteCourseButton);
        container.add(resetNameButton);
        container.add(resetPassButton);
        container.add(logoutButton);
        container.add(delAccountButton);
    }

    public void addActionEvent() {
        makeCourseButton.addActionListener(this);
        editCourseButton.addActionListener(this);
        deleteCourseButton.addActionListener(this);
        resetNameButton.addActionListener(this);
        resetPassButton.addActionListener(this);
        logoutButton.addActionListener(this);
        delAccountButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = 0;
        if (e.getSource() == delAccountButton) {
            try {
                oos.writeObject(Server.DELETE_ACCOUNT);
                oos.flush();
                String response = (String) ois.readObject();
                if(response.equals("Success")) {
                    JOptionPane.showMessageDialog(this, "Success");
                    this.dispose();
                    LoginScreen newFrame = new LoginScreen(socket, pw, oos, ois);
                    Utils.makeFrameFromTemplate(newFrame, "Login");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == resetNameButton) {
            this.dispose();
            ResetUsernameScreen currentScreen = new ResetUsernameScreen(socket, pw, oos, ois);
            Utils.makeFrameFromTemplate(currentScreen, "Edit username");
        } else if (e.getSource() == resetPassButton) {
            ResetPasswordScreen currentScreen = new ResetPasswordScreen(socket, pw, oos, ois);
            Utils.makeFrameFromTemplate(currentScreen, "Edit password");
        } else if (e.getSource() == makeCourseButton) {

        }
    }

}


