package codsoft.quiz.application;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizTimer {
    private static int currentQuestionIndex = 0;
    private static int score = 0;
    private static QuizQuestion[] quizQuestions;
    private static JLabel questionLabel;
    private static JButton[] optionButtons;
    private static Timer timer;
    private static int timeLeft;

    public static void main(String[] args) {
        quizQuestions = new QuizQuestion[] {
                new QuizQuestion("The scale of the map is...",
                        new String[]{" 1 cm represent 50 000 m", " 1 cm represent 5 000 m", " 1 cm represent 500 m", " 1 cm represent 50m"}, 'C', 10000),
                new QuizQuestion("The direction from Windmill in block E3 to trig. station no.89 in block G5 is..",
                        new String[]{" South West", " South East", " North West", " North East"}, 'B', 10000),
                new QuizQuestion("The contour interval of the topographic map is",
                        new String[]{" 5 m", " 10 m", " 15 m", " 20 m"}, 'D', 10000),
                new QuizQuestion("The length from P to Q from Source A2 is approximately between...",
                        new String[]{" 2-4 km", " 7-8 km", " 9-10 km", " 5-6 km"}, 'A', 10000),
                new QuizQuestion("A line symbol in block D5 is represented by a...",
                        new String[]{" Monument", " Contour line", " Road", " Cemetery"},'C', 10000),
        };

        JFrame frame = new JFrame("Quiz Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        questionLabel = new JLabel();
        panel.add(questionLabel);

        optionButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton();
            panel.add(optionButtons[i]);
            final int optionIndex = i;
            optionButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleAnswer(optionIndex);
                }
            });
        }

        frame.add(panel);
        showNextQuestion();

        frame.setVisible(true);
    }

    private static void showNextQuestion() {
        if (currentQuestionIndex < quizQuestions.length) {
            QuizQuestion currentQuestion = quizQuestions[currentQuestionIndex];
            questionLabel.setText(currentQuestion.getQuestionPool());
            String[] options = currentQuestion.getOptions();
            for (int i = 0; i < options.length; i++) {
                optionButtons[i].setText((char) ('A' + i) + ". " + options[i]);
            }

            timeLeft = (int) currentQuestion.getTimeLimit() / 1000;
            startTimer();

            currentQuestionIndex++;
        } else {
            showResult();
        }
    }

    private static void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft <= 0) {
                    handleAnswer(-1); // Time's up, no answer selected (-1)
                }
            }
        });
        timer.start();
    }

    private static void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    private static void handleAnswer(int optionIndex) {
        stopTimer();

        if (optionIndex == -1) {
            JOptionPane.showMessageDialog(null, "Time's up! The correct answer is " + quizQuestions[currentQuestionIndex - 1].getCorrectAnswer());
        } else if (quizQuestions[currentQuestionIndex - 1].isCorrectAnswer(Character.toString((char) ('A' + optionIndex)))) {
            score++;
            JOptionPane.showMessageDialog(null, "Correct!");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is " + quizQuestions[currentQuestionIndex - 1].getCorrectAnswer());
        }

        showNextQuestion();
    }

    private static void showResult() {
        JOptionPane.showMessageDialog(null, "Final Score: " + score + "/" + quizQuestions.length);
    }

    }
//    public static void main(String[] args) {
//        QuizQuestion[] quizQuestions = {
//                new QuizQuestion("The scale of the map is...",
//                        new String[]{" 1 cm represent 50 000 m", " 1 cm represent 5 000 m", " 1 cm represent 500 m", " 1 cm represent 50m"}, 'C', 10000),
//                new QuizQuestion("The direction from Windmill in block E3 to trig. station no.89 in block G5 is..",
//                        new String[]{" South West", " South East", " North West", " North East"}, 'B', 10000),
//                new QuizQuestion("The contour interval of the topographic map is",
//                        new String[]{" 5 m", " 10 m", " 15 m", " 20 m"}, 'D', 10000),
//                new QuizQuestion("The length from P to Q from Source A2 is approximately between...",
//                        new String[]{" 2-4 km", " 7-8 km", " 9-10 km", " 5-6 km"}, 'A', 10000),
//                new QuizQuestion("A line symbol in block D5 is represented by a...",
//                        new String[]{" Monument", " Contour line", " Road", " Cemetery"},'C', 10000),
//        };
//        int score = 0;
//
//        for (QuizQuestion quizQuestion:quizQuestions) {
//            System.out.println(quizQuestion.getQuestionPool());
//            String[] options = quizQuestion.getOptions();
//            for (int i = 0; i < options.length; i++) {
//                System.out.println((char) ('A' + i)+ ". "+ options[i]);
//
//            }
//
//            Timer timer = new Timer(quizQuestion.getTimeLimit());
//            timer.startTime();
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter your answer (A, B, C, or D): ");
//            String userAnswer = scanner.nextLine().toUpperCase();
//
//            if (quizQuestion.isCorrectAnswer(userAnswer)){
//                System.out.println("Correct!");
//                score++;
//            }else {
//                System.out.println("Incorrect. The correct answer is " + quizQuestion.getCorrectAnswer());
//            }
//
//            timer.stopTime();
//
//            System.out.println();
//
//        }
//
//        System.out.println("Final Score: " + score + "/" + quizQuestions.length);
//
//    }

