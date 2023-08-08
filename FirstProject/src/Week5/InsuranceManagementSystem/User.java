package Week5.InsuranceManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String job;
    private final int age;
    List<Address> addresses = new ArrayList<>();
    private LocalDate lastSignIn;

    public User(String firstName, String lastName, String email, String password, String job, int age)
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

    public LocalDate getLastSignIn() {
        return lastSignIn;
    }
}
