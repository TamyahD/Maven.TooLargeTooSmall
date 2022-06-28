import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    static int rangeStart = 0;
    static int rangeStop = 30;

    public static void main(String[] args) {
        Main m = new Main();
        m.run();
    }

    public void run() {
        checkGuess();
    }

    private static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        Main app = new Main();
        app.displayPrompt();
        int guess = sc.nextInt();
        return guess;
    }

    public static int generateRandomNum() {
        Random rnd = new Random();
        int randNum = rnd.nextInt(rangeStop);
        return randNum;
    }

    public void displayPrompt() {
        String prompt = ("Guess a number " + rangeStart + "-" + rangeStop + ": ");
        System.out.print(prompt);
    }

    public int checkGuess() {
        boolean userGuessing = true;
        int rNum = generateRandomNum();
        ArrayList<Integer> guesses = new ArrayList<>();
        int count = 1;

        while (userGuessing) {
            System.out.println("\nguess #" + count);
            int guess = getUserInput();
            if (guess == rNum) {
                System.out.println("you guessed correctly!");
                guesses.add(guess);
                count++;
                break;
            }
            else if (guess < rNum) {
                System.out.println(guess + " is too small");

                if (!guesses.contains(guess)) {
                    guesses.add(guess);
                }
                else if (guesses.contains(guess)){
                    System.out.println("you already guessed " + guess);
                }
                count++;
            }
            else if (guess > rNum) {
                System.out.println(guess + " is too large");
                if (!guesses.contains(guess)) {
                    guesses.add(guess);
                }
                else if (guesses.contains(guess)){
                    System.out.println("you already guessed " + guess);
                }
                count++;
            }
            else {
                System.out.println("invalid input");
                exit(5);
            }
        }
        System.out.println("\nit took " + guesses.size() + " guess(es)");
        return guesses.size();
    }
}
