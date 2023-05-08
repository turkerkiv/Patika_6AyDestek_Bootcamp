package Week1;
import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your weight: ");
        float weight = input.nextFloat();
        System.out.print("Please enter your height as meter: ");
        float height = input.nextFloat();

        float bmi = weight / (height * height);

        System.out.println("Your bmi is: " + bmi);
    }
}
