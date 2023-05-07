package VariablesPackage;

import java.util.Scanner;

public class GpaCalculatorPractice {
    public static void main(String[] args) {

        int mathResult, physicsResult, chemistryResult, languageResult, historyResult, musicResult;
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your math result: ");
        mathResult = input.nextInt();
        System.out.print("Please enter your physics result: ");
        physicsResult = input.nextInt();
        System.out.print("Please enter your chemistry result: ");
        chemistryResult = input.nextInt();
        System.out.print("Please enter your language result: ");
        languageResult = input.nextInt();
        System.out.print("Please enter your history result: ");
        historyResult = input.nextInt();
        System.out.print("Please enter your music result: ");
        musicResult = input.nextInt();

        int total = mathResult + physicsResult + chemistryResult + languageResult + historyResult + musicResult;
        double averageResult = total / 6d;

        String finalOutput = averageResult > 60 ? "You passed the class! Average: " + averageResult  : "You failed the class! Average: " + averageResult;
        System.out.println(finalOutput);
    }
}
