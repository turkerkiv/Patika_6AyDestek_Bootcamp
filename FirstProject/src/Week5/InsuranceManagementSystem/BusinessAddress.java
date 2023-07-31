package Week5.InsuranceManagementSystem;

public class BusinessAddress implements Address{
    private String country;
    private String city;
    private String fullAddress;

    BusinessAddress(String country, String city, String fullAddress)
    {
        this.country = country;
        this.city = city;
        this.fullAddress = fullAddress;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getFullAddress() {
        return fullAddress;
    }
}