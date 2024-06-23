import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String playAgain;

        System.out.println("Welcome to The Guess Number Game!");
        System.out.print("Please enter your name: ");
        String username = sc.nextLine();
        System.out.println("Hello " + username + "! Let's start the game!");

        do {
            playGame(sc);
            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = sc.nextLine().trim().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("Thank you for playing, " + username + "! Goodbye!");
        sc.close();
    }

    private static void playGame(Scanner sc) {
        Random rd = new Random();
        int numberToGuess = rd.nextInt(100) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("I have selected a number between 1 and 100.");

        while (!guessedCorrectly) {
            System.out.print("Please enter your guess: ");
            int userGuess = 0;

            try {
                userGuess = Integer.parseInt(sc.nextLine());
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again.");
                    if (attempts % 3 == 0) {
                        System.out.println("Hint: The number is greater than " + (userGuess + 5));
                    }
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Try again.");
                    if (attempts % 3 == 0) {
                        System.out.println("Hint: The number is less than " + (userGuess - 5));
                    }
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
