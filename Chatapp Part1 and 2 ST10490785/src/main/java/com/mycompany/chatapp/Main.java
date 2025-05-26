package com.mycompany.chatapp;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Login", "Register"};
        int choice = JOptionPane.showOptionDialog(null, "Welcome to chatApp", "chatApp",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            String username = JOptionPane.showInputDialog("username:");
            String password = JOptionPane.showInputDialog("password:");
            if (Login.loginUser(username, password)) {
                MyChatApp.displayMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Login.");
            }
        } else if (choice == 1) {
            Login.registerUser();
        }
    }
}

