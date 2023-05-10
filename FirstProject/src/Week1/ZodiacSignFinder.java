package Week1;

import java.util.Scanner;

public class ZodiacSignFinder {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the month you born as number: ");
        int month = input.nextInt();

        System.out.print("Please enter the day you born as number: ");
        int day = input.nextInt();

        String sign = "";

        if(month == 1)
        {
            sign = day >= 22 ? "Aquarius" : "Capricorn";
        }
        else if(month == 2){
            sign = day >= 20 ? "Pisces" : "Aquarius";
        }
        else if(month == 3){
            sign = day >= 21 ? "Aries" : "Pisces";
        }
        else if(month == 4){
            sign = day >= 21 ? "Taurus" : "Aries";
        }
        else if(month == 5){
            sign = day >= 22 ? "Gemini" : "Taurus";
        }
        else if(month == 6){
            sign = day >= 23 ? "Cancer" : "Gemini";
        }
        else if(month == 7){
            sign = day >= 23 ? "Leo" : "Cancer";
        }
        else if(month == 8){
            sign = day >= 23 ? "Virgo" : "Leo";
        }
        else if(month == 9){
            sign = day >= 23 ? "Libra" : "Virgo";
        }
        else if(month == 10){
            sign = day >= 23 ? "Scorpio" : "Libra";
        }
        else if(month == 11){
            sign = day >= 22 ? "Sagittarius" : "Scorpio";
        }
        else if(month == 12){
            sign = day >= 22 ? "Capricorn" : "Sagittarius";
        }

        System.out.println("Your zodiac sign is: " + sign);
    }
}
