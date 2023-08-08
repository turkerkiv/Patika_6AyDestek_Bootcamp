package Week5.InsuranceManagementSystem;

public class AddressManager {
    private final User user;

    public AddressManager(User user)
    {
        this.user = user;
    }

    public void addAddress(Address address)
    {
        user.getAddresses().add(address);
    }

    public void removeAddress(Address address)
    {
        user.getAddresses().remove(address);
    }
}
