package fixit.model;


import com.vividsolutions.jts.geom.Geometry;

//@Entity
public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final String zipCode;
    public final Geometry location;
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
                   Geometry location,
                   int profileId,
                   boolean isDeleted)
    {
        this.id = id;
        this.zipCode = zipCode;
        this.location = location;
        this.city = city;
        this.state = state;
        this.country = country;
        this.streetAddress = streetAddress;
        this.profileId = profileId;
        this.isDeleted = isDeleted;
    }
}
