package fixit.model;



import java.util.List;

//@Entity
public class ContractorProfile
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final int categoryId;
    public final double hourlyRate;
    public final double overallScore;
    public final int contactInfoId;
    public final List<Long> reviewsId;
    public final MembershipType memberType; //Standard, Premium or whatever
    public final int addressId;
    public final String username;
    public final String password;
    public final boolean isDeleted;

    public ContractorProfile(int id,
                             int categoryId,
                             double hourlyRate,
                             double overallScore,
                             int contactInfoId,
                             List<Long> reviewsIds,
                             MembershipType memberType,
                             int addressId,
                             String username,
                             String password,
                             boolean isDeleted)
    {
        this.id = id;
        this.categoryId = categoryId;
        this.hourlyRate = hourlyRate;
        this.overallScore = overallScore;
        this.contactInfoId = contactInfoId;
        this.reviewsId = reviewsIds;
        this.memberType = memberType;
        this.addressId = addressId;
        this.username = username;
        this.password = password;
        this.isDeleted = isDeleted;
    }
}
