package com.example.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginScreen extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton signUpButton = new JButton("SIGN UP (TEACHER)");
    JButton signUpAsStudent = new JButton("SIGN UP (STUDENT)");


    JCheckBox showPassword = new JCheckBox("Show Password");

    Socket socket;
    PrintWriter pw;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    LoginScreen(Socket socket) {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.socket = socket;

        try {
            pw = new PrintWriter(socket.getOutputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        signUpButton.setBounds(100, 350, 175, 30);
        signUpAsStudent.setBounds(100,400,175,30);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(signUpButton);
        container.add(signUpAsStudent);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        signUpButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            User user = new User(userTextField.getText(), passwordField.getText());
            try {
                oos.writeObject(2);
                oos.writeObject(user);
                oos.flush();
                String response = (String) ois.readObject();
                if(response.equals("Success")) {
                    JOptionPane.showMessageDialog(this, "Success");
                } else {
                    JOptionPane.showMessageDialog(this, response);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }

        if (e.getSource() == signUpAsStudent) { //make a student
            User user = new User(userTextField.getText(), passwordField.getText());
            try {
                oos.writeObject(0);
                oos.writeObject(user);
                oos.flush();
                String response = (String) ois.readObject();
                if(response.equals("Success")) {
                    JOptionPane.showMessageDialog(this, "Success");
                } else {
                    JOptionPane.showMessageDialog(this, response);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == signUpButton) { //make a teacher
            User user = new User(userTextField.getText(), passwordField.getText());
            try {
                oos.writeObject(1);
                oos.writeObject(user);
                oos.flush();
                String response = (String) ois.readObject();
                if(response.equals("Success")) {
                    JOptionPane.showMessageDialog(this, "Success");
                } else {
                    JOptionPane.showMessageDialog(this, response);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }


    }

}

