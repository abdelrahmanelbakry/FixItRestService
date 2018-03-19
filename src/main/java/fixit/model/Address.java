package fixit.model;

//@Entity
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final String zipCode;
    public final long longtitude;
    public final long lattitude;
    public final String city;
    public final String state;
    public final String country;
    public final String streetAddress;
    public final int profileId;
    public final boolean isDeleted;
    
    public Address(int id,
                   String streetAddress,
                   String city,
                   String state,
                   String country,
                   String zipCode,
                   long longtitude,
                   long lattitude,
                   int profileId,
                   boolean isDeleted)
    {
        this.id = id;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.streetAddress = streetAddress;
        this.longtitude = longtitude;
        this.lattitude = lattitude;
        this.profileId = profileId;
        this.isDeleted = isDeleted;
    }
}
