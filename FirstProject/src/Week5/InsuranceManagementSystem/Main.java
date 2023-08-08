package Week5.InsuranceManagementSystem;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        AccountManager accManager = new AccountManager();

        //user 1
        User user1 = new User("Türker", "Kıvılcım", "deneme@gmail.com", "123456","soft-dev", 21);

        //IMPROVEMENT could be better with make address manager in user class and then move addresses in address manager
        AddressManager user1AddressManager = new AddressManager(user1);
        HomeAddress user1HomeAddress = new HomeAddress("Turkey","Hatay", "...");
        BusinessAddress user1BusinessAddress = new BusinessAddress("Turkey", "Hatay", "...");
        user1AddressManager.addAddress(user1HomeAddress);
        user1AddressManager.addAddress(user1BusinessAddress);

        Account user1Acc = new IndividualAccount(user1);

        HealthInsurance user1HealthInsurance = new HealthInsurance(1.5, LocalDate.of(2022, 8, 3), LocalDate.of(2023,8,3));
        ResidenceInsurance user1ResidenceInsurance = new ResidenceInsurance(5.3, LocalDate.of(2022,9,28), LocalDate.of(2023,12, 20));
        user1Acc.addInsurance(user1HealthInsurance);
        user1Acc.addInsurance(user1ResidenceInsurance);

        //user 2
        User user2 = new User("Kalph", "jale", "kalph@gmail.com", "123", "miner", 35);

        AddressManager user2AddressManager = new AddressManager(user2);
        HomeAddress user2HomeAddress = new HomeAddress("France","Paris", "...");
        BusinessAddress user2BusinessAddress = new BusinessAddress("England", "London", "...");
        user2AddressManager.addAddress(user2HomeAddress);
        user2AddressManager.addAddress(user2BusinessAddress);

        Account user2Acc = new EnterpriseAccount(user2, 0.8);

        CarInsurance user2CarInsurance = new CarInsurance(8.3, LocalDate.of(2022,1,25), LocalDate.of(2023,2,25));
        ResidenceInsurance user2ResidenceInsurance = new ResidenceInsurance(5.3, LocalDate.of(2022,9,28), LocalDate.of(2023,12, 20));
        user2Acc.addInsurance(user2CarInsurance);
        user2Acc.addInsurance(user2ResidenceInsurance);

        //IMPROVEMENT instead of this, could be better to make a menu and use user input to create account etc.

        accManager.addAccount(user1Acc);
        accManager.addAccount(user2Acc);

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome!!! To log in, please");
        System.out.println("Enter your email: ");
        String email = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();

        try{
            Account loggedInAcc = accManager.logIn(email, password);
            loggedInAcc.showUserInfo();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
