import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 10;
        int score = 0;

        System.out.println("Welcome to the Number Game!");
        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean correctGuess = false;

            while (attempts < attemptsLimit && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a valid guess within the specified range.");
                    continue;
                }

                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    correctGuess = true;
                    score++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");

            if (playAgain) {
                System.out.println("Great! Let's play again.");
            } else {
                System.out.println("Thanks for playing! Your final score is: " + score);
            }
        }

        scanner.close();
    }
}

