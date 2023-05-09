package Week1;

import java.util.Scanner;
public class UserLogin {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        if(username.equals("Admin") && password.equals("Password1")){
            System.out.println("Welcome!");
        }
        else {
            System.out.println("Failed to login! Do you wanna reset your password? (1)Yes (2)No");

            int choice = input.nextInt();
            input.nextLine(); //a \n coming from the resetting input when i press enter. So this is for absorbing that.
            if(choice == 1)
            {
                System.out.print("Enter a new password: ");
                String newPassword = input.nextLine();

                if(!newPassword.equals(password) && !newPassword.equals("Password1"))
                {
                    password = newPassword;
                    System.out.println("New password created successfully!");
                }
                else {
                    System.out.println("Failed, please try another password.");
                }
            }
            else if(choice == 2){
                System.out.print("OK, Bye!");
            }
        }


    }
}
