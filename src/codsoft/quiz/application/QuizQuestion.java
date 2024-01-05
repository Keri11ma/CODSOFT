package codsoft.quiz.application;

public class QuizQuestion {
    private String questionPool;
    private String[] options;
    private char correctAnswer;

    private long timeLimit;
    
    public QuizQuestion(String questionPool, String[] options, char correctAnswer, long timeLimit){
        this.questionPool = questionPool;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.timeLimit = timeLimit;
    }

    public String getQuestionPool() {
        return questionPool;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrectAnswer(String userAnswer){
        return userAnswer.equals(Character.toString((char) ('A' + (correctAnswer - 'A'))));
    }


    public long getTimeLimit() {
        return timeLimit;
    }
}
