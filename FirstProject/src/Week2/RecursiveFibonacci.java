package Week2;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to find fibonacci with element: ");
        int num = input.nextInt();
        System.out.print(Fibonacci(num));
    }

    static int Fibonacci(int num)
    {
        if(num < 2) return 1;
        int total = Fibonacci(num - 1) + Fibonacci(num - 2);
        return total;
    }
}
