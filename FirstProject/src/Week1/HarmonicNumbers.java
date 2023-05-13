package Week1;
import java.util.Scanner;
public class HarmonicNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number that you wanna find harmonic series of it: ");
        int num = input.nextInt();

        double harmonic = 0;
        for(int i = 1; i <= num; i++)
        {
            harmonic += (1d / i);
        }

        System.out.println("Harmonic result: " + harmonic);
    }
}
