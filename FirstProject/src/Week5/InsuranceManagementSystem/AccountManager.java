package Week5.InsuranceManagementSystem;

import java.util.Set;
import java.util.TreeSet;

public class AccountManager {
    private final Set<Account> accounts = new TreeSet<>();
    //todo add comparator

    public void logIn(String email, String password)
    {
        //todo
    }

    public void addAccount(Account acc)
    {
        accounts.add(acc);
    }
}
