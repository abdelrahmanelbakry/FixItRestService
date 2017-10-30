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

    public ContractorProfile(int id,
                             int categoryId,
                             double hourlyRate,
                             double overallScore,
                             int contactInfoId,
                             List<Long> reviewsIds,
                             MembershipType memberType,
                             int addressId)
    {
        this.id = id;
        this.categoryId = categoryId;
        this.hourlyRate = hourlyRate;
        this.overallScore = overallScore;
        this.contactInfoId = contactInfoId;
        this.reviewsId = reviewsIds;
        this.memberType = memberType;
        this.addressId = addressId;
    }
}
