package fixit.model;


//@Entity
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final String zipCode;
    public final int locationId;
    public final String city;
    public final String state;
    public final String country;
    public final String streetAddress;

    public Address(int id,
                   String streetAddress,
                   String city,
                   String state,
                   String country,
                   String zipCode,
                   int locationId)
    {
        this.id = id;
        this.zipCode = zipCode;
        this.locationId = locationId;
        this.city = city;
        this.state = state;
        this.country = country;
        this.streetAddress = streetAddress;
    }
}
