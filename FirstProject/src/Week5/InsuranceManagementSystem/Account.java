package Week5.InsuranceManagementSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Account{
    private AuthenticationStatus logInStatus;
    private  User user;
    private List<Insurance> activeInsurances = new ArrayList<>();

    public AuthenticationStatus getLogInStatus() {
        return logInStatus;
    }

    public final void showUserInfo()
    {
        //todo
    }

    public void logIn(String email, String password)
    {
        //todo
    }

    public abstract void addInsurancePolicy();

    //todo implement comparable
    //todo hashcode
    //todo equals
    //todo compareto
}
