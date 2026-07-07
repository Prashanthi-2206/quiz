import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Result extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel nameLabel;
    JLabel scoreLabel;
    JLabel percentageLabel;
    JLabel resultLabel;

    JButton exitButton;

    public Result(String username, int score, int totalQuestions) {

        setTitle("Quiz Result");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title
        titleLabel = new JLabel("ONLINE QUIZ RESULT");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(90, 20, 350, 30);

        // Username
        nameLabel = new JLabel("Candidate : " + username);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        nameLabel.setBounds(70, 90, 300, 25);

        // Score
        scoreLabel = new JLabel("Score : " + score + " / " + totalQuestions);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        scoreLabel.setBounds(70, 130, 300, 25);

        // Percentage
        double percentage = ((double) score / totalQuestions) * 100;

        percentageLabel = new JLabel("Percentage : " + percentage + "%");
        percentageLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        percentageLabel.setBounds(70, 170, 300, 25);

        // Pass / Fail
        if (percentage >= 50) {
            resultLabel = new JLabel("Result : PASS");
            resultLabel.setForeground(new Color(0, 128, 0)); // Green
        } else {
            resultLabel = new JLabel("Result : FAIL");
            resultLabel.setForeground(Color.RED);
        }

        resultLabel.setFont(new Font("Arial", Font.BOLD, 22));
        resultLabel.setBounds(70, 220, 250, 30);

        // Exit Button
        exitButton = new JButton("Exit");
        exitButton.setBounds(180, 290, 120, 40);
        exitButton.addActionListener(this);

        add(titleLabel);
        add(nameLabel);
        add(scoreLabel);
        add(percentageLabel);
        add(resultLabel);
        add(exitButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this,
                "Thank you for taking the quiz!");

        System.exit(0);
    }
}