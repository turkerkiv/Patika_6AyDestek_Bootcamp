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

    public Account logIn(String email, String password) throws Exception
    {
        Account result = null;
        for(Account a : accounts)
        {
            if(a.logIn(email,password))
            {
                result = a;
            }
        }
        if(result == null) throw new InvalidAuthenticationException();
        return result;
    }

    public void addAccount(Account acc)
    {
        accounts.add(acc);
    }
}
