package Week1;
import java.util.Scanner;
public class GreengrocerCheckout {

    public static void main(String[] args) {
        //Prices
        final float PEAR = 2.14f;
        final float APPLE = 3.67f;
        final float TOMATO = 1.11f;
        final float BANANA = 0.95f;
        final float AUBERGINE = 5.0f;

        Scanner input = new Scanner(System.in);

        System.out.print("How many kilos of pear? ");
        float kiloOfPear = input.nextFloat();
        System.out.print("How many kilos of apple? ");
        float kiloOfApple = input.nextFloat();
        System.out.print("How many kilos of tomato? ");
        float kiloOfTomato = input.nextFloat();
        System.out.print("How many kilos of banana? ");
        float kiloOfBanana = input.nextFloat();
        System.out.print("How many kilos of aubergine? ");
        float kiloOfAubergine = input.nextFloat();

        float total = (kiloOfPear * PEAR)+(kiloOfApple * APPLE)+(kiloOfTomato * TOMATO) + (kiloOfBanana * BANANA) + (kiloOfAubergine * AUBERGINE);

        System.out.println("Your total: " + total);
    }
}
