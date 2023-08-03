package Week5.InsuranceManagementSystem;

public class InvalidAuthenticationException extends Exception{

    InvalidAuthenticationException()
    {
        super("Invalid email or password");
    }
}
