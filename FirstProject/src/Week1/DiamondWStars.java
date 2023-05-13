package Week1;
import java.util.Scanner;
public class DiamondWStars {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        for(int i = 0; i < num; i++)
        {
            System.out.println();
            for(int i2 = 0; i2 < num - i; i2++)
            {
                System.out.print(" ");
            }
            for(int i3 = 0; i3 < (i * 2) + 1; i3++)
            {
                System.out.print("*");
            }
        }
        
        for(int i = num -1 ; i >= 0 ; i--)
        {
            System.out.println();
            for(int i2 = 0; i2 < num - i; i2++)
            {
                System.out.print(" ");
            }
            for(int i3 = 0; i3 < (i * 2) + 1; i3++)
            {
                System.out.print("*");
            }
        }
    }
}
