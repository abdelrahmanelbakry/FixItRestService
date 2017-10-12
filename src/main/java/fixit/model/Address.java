package fixit.model;


public class Address {
    public final String zipCode;
    public final Location location;
    public final String city;
    public final String state;
    public final String country;

    public Address(String zipCode,
                   fixit.model.Location location,
                   String city,
                   String state,
                   String country) {
        this.zipCode = zipCode;
        this.location = location;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
