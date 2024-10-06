import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int rounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("Round " + (rounds + 1));
            System.out.println("Guess a number between 1 and 100.");

            while (!guessed && attempts < 6) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += 10 - attempts;
                    guessed = true;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("Sorry, you didn't guess the number. It was " + numberToGuess + ".");
            }

            System.out.println("Your current score: " + score);
            rounds++;

            System.out.print("Play again? (yes/no): ");
            String input = scanner.next().toLowerCase();

            playAgain = input.equals("yes");
        }

        System.out.println("Game over. Final score: " + score + " points in " + rounds + " rounds.");
        scanner.close();
    }
}


