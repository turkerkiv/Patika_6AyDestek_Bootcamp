package Week2;
import java.util.Scanner;
public class PalindromicWords {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a word to find if it is palindromic: ");
        String wordInp = inp.nextLine();

        String reversedStr = "";

        for(int i = wordInp.length() - 1; i >= 0; i--)
        {
            reversedStr += wordInp.charAt(i);
        }

        if(reversedStr.equals(wordInp)) System.out.println(wordInp + " is palindromic. Reversed: " + reversedStr);
        else System.out.println(wordInp + " is not palindromic. Reversed: " + reversedStr );
    }
}

