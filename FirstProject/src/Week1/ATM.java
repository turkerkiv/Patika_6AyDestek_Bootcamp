package Week1;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int right = 3;
        int balance = 1500;
        int select;
        while (right > 0) {
            System.out.print("User name: ");
            userName = input.nextLine();
            System.out.print("Password: ");
            password = input.nextLine();

            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("Hello, Welcome to the Kodluyoruz Bank!");
                do {
                    System.out.println("""
                            1-Deposit
                            2-Withdraw
                            3-Balance Inquiry
                            4-Exit""");
                    System.out.print("Please select the option you wanna perform: ");
                    select = input.nextInt();
                    switch (select) {
                        case 1 -> {
                            System.out.print("Amount: ");
                            int price = input.nextInt();
                            balance += price;
                        }
                        case 2 -> {
                            System.out.print("Amount: ");
                            int price = input.nextInt();
                            if (price > balance) {
                                System.out.println("Not enough balance.");
                            } else {
                                balance -= price;
                            }
                        }
                        case 3 -> System.out.println("Balance: " + balance);
                    }
                } while (select != 4);
                System.out.println("See you soon.");
                break;
            } else {
                right--;
                System.out.println("Incorrect user name or password. Please retry.");
                if (right == 0) {
                    System.out.println("Your account blocked. Please contact to your bank.");
                } else {
                    System.out.println("Remaining trial: " + right);
                }
            }
        }
    }
}