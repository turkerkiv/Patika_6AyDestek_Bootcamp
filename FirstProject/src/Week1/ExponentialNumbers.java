package Week1;
import java.util.Scanner;
public class ExponentialNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a base number: ");
        int baseNum = input.nextInt();

        System.out.print("Enter exponential count: ");
        int expCount = input.nextInt();

        int result = 1;
        for(int i = 1; i <= expCount; i++)
        {
            result *= baseNum;
        }

        System.out.println("Result: " + result);
    }
}
