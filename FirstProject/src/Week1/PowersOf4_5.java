package Week1;
import java.util.Scanner;
public class PowersOf4_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number to find powers of 4 and 5 until that number: ");
        int num = input.nextInt();

        for(int i = 4; i <= num; i*=4)
        {
            System.out.println("Power of 4: "+i);
        }
        for (int i = 5; i <= num; i*=5)
        {
            System.out.println("Power of 5: "+i);
        }
    }
}
