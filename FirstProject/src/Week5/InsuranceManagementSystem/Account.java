package Week5.InsuranceManagementSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Comparable{
    private AuthenticationStatus logInStatus;
    private final User user;
    private List<Insurance> activeInsurances = new ArrayList<>();

    Account(User user)
    {
        this.user = user;
    }

    public final void showUserInfo()
    {
        System.out.println("Log in status: " + logInStatus);
        System.out.println();
        System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
        System.out.println();
        System.out.println("Here is your information: ");
        System.out.println("Age: " + user.getAge());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Job: " + user.getJob());

        System.out.println();
        System.out.println("All addresses");
        for(int i = 0; i < user.getAddresses().size(); i++)
        {
            Address address = user.addresses.get(i);
            System.out.println("Address " + (i+1) + ": Country: " +  address.getCountry() + " --- City: " + address.getCity() + " --- Full Address: " + address.getFullAddress());
        }

        System.out.println();
        System.out.println("All active insurances");
        for(Insurance i : activeInsurances)
        {
            System.out.println( "Name: "+i.getName() + " --- start date: " + i.getStartDate() + " --- end date: " + i.getEndDate() + " --- total price: " + String.format("%.2f", i.getFinalPrice()));
        }
    }

    public boolean logIn(String email, String password)
    {
        if(user.getEmail().equals(email) && user.getPassword().equals(password))
        {
            logInStatus = AuthenticationStatus.SUCCESS;
            return true;
        }
        else {
            logInStatus = AuthenticationStatus.FAIL;
            return false;
        }
    }

    public AuthenticationStatus getLogInStatus() {
        return logInStatus;
    }

    public int hashCode()
    {
        return user.getEmail().hashCode() + user.getFirstName().hashCode();
    }

    public boolean equals(Object obj) {
        return ((Account)obj).hashCode() == hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(hashCode(), ((Account)o).hashCode());
    }

    public List<Insurance> getActiveInsurances()
    {
        return activeInsurances;
    }

    public abstract void addInsurance(Insurance i);
}
