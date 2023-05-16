package Week2;

import java.util.Scanner;

public class PalindromeFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        FindPalindrome(input.nextInt());
    }

    static void FindPalindrome(int num)
    {
        int temp = num, lastNum, reverseNum = 0;

        while(temp > 0)
        {
            lastNum = temp % 10;
            reverseNum = (reverseNum * 10) + lastNum;
            temp /= 10;
        }

        if(reverseNum == num) System.out.println(num + " is a palindrome number");
        else System.out.println(num + " is not a palindrome number");
    }
}
