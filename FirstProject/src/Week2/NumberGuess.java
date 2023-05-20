package Week2;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int randomNum = (int) (Math.random() * 100);
        System.out.println("Computer picked a number between 1 and 100.");
        System.out.print("Enter a number to guess: ");
        int guess = inp.nextInt();
        int rights = 5;

        while(guess != randomNum && rights > 1)
        {
            rights--;
            if(guess > randomNum) System.out.println("Wrong! You guessed greater number. Remaining rights: " + rights);
            else System.out.println("Wrong! You guessed smaller number. Remaining rights: " + rights);
            System.out.print("Enter a new number to guess: ");
            guess = inp.nextInt();
        }

        if(guess == randomNum) System.out.println("You guessed true! Congratulations");
        else System.out.println("Game finished. You don't have remaining rights to play. Please play again.");

    }
}
