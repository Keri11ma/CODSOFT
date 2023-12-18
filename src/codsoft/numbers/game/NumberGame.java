package codsoft.numbers.game;

import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 5;
    private static final int RANGE = 100;
    private int score = 0;
    private boolean playAgain = true;

    private final Generator generator;
    private final Player player;
    private final Scanner scanner;

    public NumberGame() {
        this.generator = new Generator(RANGE);
        this.player = new Player(MAX_ATTEMPTS);
        this.scanner = new Scanner(System.in);
    }

    public void playGame() {
        while (playAgain) {
            int randomNumber = generator.generateCode();
            int attempts = 0;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between 1 and " + RANGE + ".");

            while (attempts < MAX_ATTEMPTS) {
                if (player.isQuit()) {
                    playAgain = false;
                    break;
                }

                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "): ");
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("quit")) {
                    playAgain = false;
                    break;
                }

                try {
                    int userGuess = Integer.parseInt(userInput);

                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You guessed the correct number.");
                        score++;
                        break;
                    } else if (userGuess < randomNumber) {
                        System.out.println("Too low. Try a higher number.");
                    } else {
                        System.out.println("Too high. Try a lower number.");
                    }

                    attempts++;
                    player.decrementTurns();
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number or type 'quit' to exit.");
                }
            }

            if (!playAgain) {
                break;
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next();

            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Game over. Your total score is: " + score);
        scanner.close();
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        game.playGame();
    }
}


