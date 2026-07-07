import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {

    JLabel questionLabel, questionNumber;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup group;
    JButton nextButton, submitButton;

    String username;

    String[][] questions = {
            {
                    "Which language is platform independent?",
                    "Java",
                    "C",
                    "C++",
                    "Python",
                    "Java"
            },
            {
                    "Who developed Java?",
                    "Google",
                    "Microsoft",
                    "Sun Microsystems",
                    "IBM",
                    "Sun Microsystems"
            },
            {
                    "Which keyword is used for inheritance?",
                    "extends",
                    "implements",
                    "package",
                    "import",
                    "extends"
            },
            {
                    "Which company owns Java now?",
                    "Oracle",
                    "Google",
                    "IBM",
                    "Apple",
                    "Oracle"
            },
            {
                    "Which loop executes at least once?",
                    "for",
                    "while",
                    "do-while",
                    "foreach",
                    "do-while"
            }
    };

    int current = 0;
    int score = 0;

    public Quiz(String username) {

        this.username = username;

        setTitle("Online Quiz System");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        questionNumber = new JLabel();
        questionNumber.setBounds(30, 20, 100, 30);
        questionNumber.setFont(new Font("Arial", Font.BOLD, 18));

        questionLabel = new JLabel();
        questionLabel.setBounds(30, 60, 550, 30);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        option1 = new JRadioButton();
        option1.setBounds(50, 110, 500, 30);

        option2 = new JRadioButton();
        option2.setBounds(50, 150, 500, 30);

        option3 = new JRadioButton();
        option3.setBounds(50, 190, 500, 30);

        option4 = new JRadioButton();
        option4.setBounds(50, 230, 500, 30);

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        nextButton = new JButton("Next");
        nextButton.setBounds(150, 300, 120, 35);

        submitButton = new JButton("Submit");
        submitButton.setBounds(330, 300, 120, 35);

        nextButton.addActionListener(this);
        submitButton.addActionListener(this);

        add(questionNumber);
        add(questionLabel);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
        add(nextButton);
        add(submitButton);

        loadQuestion();

        setVisible(true);
    }

    void loadQuestion() {

        group.clearSelection();

        questionNumber.setText("Q" + (current + 1));

        questionLabel.setText(questions[current][0]);

        option1.setText(questions[current][1]);
        option2.setText(questions[current][2]);
        option3.setText(questions[current][3]);
        option4.setText(questions[current][4]);

        if (current == questions.length - 1) {
            nextButton.setEnabled(false);
        }
    }

    void checkAnswer() {

        String answer = "";

        if (option1.isSelected())
            answer = option1.getText();

        else if (option2.isSelected())
            answer = option2.getText();

        else if (option3.isSelected())
            answer = option3.getText();

        else if (option4.isSelected())
            answer = option4.getText();

        if (answer.equals(questions[current][5])) {
            score++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == nextButton) {

            checkAnswer();

            current++;

            if (current < questions.length) {
                loadQuestion();
            }

        }

        if (e.getSource() == submitButton) {

            checkAnswer();

            JOptionPane.showMessageDialog(this,
                    "Quiz Submitted!");

            dispose();

            new Result(username, score, questions.length);
        }
    }
}