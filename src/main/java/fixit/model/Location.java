package fixit.model;


//@Entity
public class Location
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final long id;
    public final long longtitude;
    public final long latitude;

    public Location(long id, long longtitude, long latitude) {
        this.id = id;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }
}
