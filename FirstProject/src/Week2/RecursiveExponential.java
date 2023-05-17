package Week2;
import java.util.Scanner;

public class RecursiveExponential {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter base number: ");
        int baseNum = input.nextInt();
        System.out.print("Enter power of base number: ");
        int powerNum = input.nextInt();

        int result = calculateExponential(baseNum, powerNum);
        System.out.println("Result: " + result);
    }

    static int calculateExponential(int baseNum, int powerNum)
    {
        if(powerNum < 1) return 1;
        return baseNum * calculateExponential(baseNum, powerNum - 1);
    }
}
