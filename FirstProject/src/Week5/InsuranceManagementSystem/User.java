package Week5.InsuranceManagementSystem;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String job;
    private int age;
    List<Address> addresses = new ArrayList<Address>();
    private Date lastSignIn;

    User(String firstName, String lastName, String email, String password, String job, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.job = job;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Date getLastSignIn() {
        return lastSignIn;
    }
}
