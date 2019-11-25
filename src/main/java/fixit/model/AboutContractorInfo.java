package fixit.model;



//@Entity
public class AboutContractorInfo
{
    public final int id;
    public final String name;
    public final String phoneNumber;
    public final String faxNumber;
    public final String emailAddress;
    public final String about;
    public final PreferredContactMethod preferredContactMethod;

    public AboutContractorInfo(int id,
                               String name,
                               String phoneNumber,
                               String faxNumber,
                               String emailAddress,
                               String about,
                               PreferredContactMethod preferredContactMethod)
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
        this.about = about;
        this.preferredContactMethod = preferredContactMethod;
    }
}
