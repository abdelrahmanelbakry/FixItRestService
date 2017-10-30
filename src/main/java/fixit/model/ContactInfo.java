package fixit.model;



//@Entity
public class ContactInfo
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final String name;
    public final String phoneNumber;
    public final String faxNumber;
    public final String emailAddress;
    public final PreferredContactMethod preferredContactMethod;

    public ContactInfo(int id,
                       String name,
                       String phoneNumber,
                       String faxNumber,
                       String emailAddress,
                       PreferredContactMethod preferredContactMethod) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
        this.preferredContactMethod = preferredContactMethod;
    }
}
