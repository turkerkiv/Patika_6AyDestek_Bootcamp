package Week1;

import java.util.Scanner;

public class GpaCalculator2 {
    public static void main(String[] args) {

        int mathResult, physicsResult, chemistryResult, languageResult, historyResult, musicResult, invalidLessonCount = 0;
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your math result: ");
        mathResult = input.nextInt();
        if(mathResult < 0 || mathResult > 100) {
            mathResult = 0;
            invalidLessonCount++;
        }

        System.out.print("Please enter your physics result: ");
        physicsResult = input.nextInt();
        if(physicsResult < 0 || physicsResult> 100) {
            physicsResult = 0;
            invalidLessonCount++;
        }

        System.out.print("Please enter your chemistry result: ");
        chemistryResult = input.nextInt();
        if(chemistryResult < 0 || chemistryResult > 100) {
            chemistryResult= 0;
            invalidLessonCount++;
        }

        System.out.print("Please enter your language result: ");
        languageResult = input.nextInt();
        if(languageResult < 0 || languageResult> 100) {
            languageResult= 0;
            invalidLessonCount++;
        }

        System.out.print("Please enter your history result: ");
        historyResult = input.nextInt();
        if(historyResult< 0 || historyResult> 100) {
            historyResult= 0;
            invalidLessonCount++;
        }

        System.out.print("Please enter your music result: ");
        musicResult = input.nextInt();
        if(musicResult< 0 || musicResult> 100) {
            musicResult = 0;
            invalidLessonCount++;
        }

        double total = mathResult + physicsResult + chemistryResult + languageResult + historyResult + musicResult;
        double gpa = total / (6 - (Math.min(invalidLessonCount, 5)));

        String finalOutput = gpa > 55 ? "You passed the class! Average: " + gpa  : "You failed the class! Average: " + gpa;
        System.out.println(finalOutput);
    }
}
