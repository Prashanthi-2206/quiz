import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel titleLabel, userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginButton, clearButton;

    public Login() {

        setTitle("Online Quiz System - Login");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titleLabel = new JLabel("ONLINE QUIZ SYSTEM");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setBounds(90, 20, 300, 30);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 80, 100, 25);

        userField = new JTextField();
        userField.setBounds(150, 80, 200, 25);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 120, 100, 25);

        passField = new JPasswordField();
        passField.setBounds(150, 120, 200, 25);

        loginButton = new JButton("Login");
        loginButton.setBounds(90, 180, 100, 35);

        clearButton = new JButton("Clear");
        clearButton.setBounds(220, 180, 100, 35);

        loginButton.addActionListener(this);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                passField.setText("");
            }
        });

        add(titleLabel);
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);
        add(clearButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = userField.getText();
        String password = new String(passField.getPassword());

        // Default Login
        if (username.equals("admin") && password.equals("1234")) {

            JOptionPane.showMessageDialog(this,
                    "Login Successful!");

            dispose();

            new Quiz(username);

        } else {

            JOptionPane.showMessageDialog(this,
                    "Invalid Username or Password");

        }
    }
}