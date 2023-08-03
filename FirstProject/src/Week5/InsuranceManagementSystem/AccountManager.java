package Week5.InsuranceManagementSystem;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AccountManager {
    private final Set<Account> accounts = new TreeSet<>(new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o1.compareTo(o2);
        }
    });

    public Account logIn(String email, String password)
    {
        for(Account a : accounts)
        {
            //todo instead of boolean use try catch and custom invalidauthenticationexception
            if(a.logIn(email,password)){
                return a;
            }
        }
        return null;
    }

    public void addAccount(Account acc)
    {
        accounts.add(acc);
    }
}
