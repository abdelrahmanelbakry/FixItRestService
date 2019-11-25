package fixit.model;

import java.util.List;

public class MapAnnotation {

    public final int id;
    public final int categoryId;
    public final double hourlyRate;
    public final double overallScore;
    public final AboutContractorInfo aboutContractorInfo;
    public final List<Review> reviewSnippet;
    public final MembershipType memberType; //Standard, Premium or whatever
    public final Address address;

    public MapAnnotation(int id,
                         int categoryId,
                         double hourlyRate,
                         double overallScore,
                         AboutContractorInfo aboutContractorInfo,
                         List<Review> reviewSnippet,
                         MembershipType memberType,
                         Address address)
    {
        this.id = id;
        this.categoryId = categoryId;
        this.hourlyRate = hourlyRate;
        this.overallScore = overallScore;
        this.aboutContractorInfo = aboutContractorInfo;
        this.reviewSnippet = reviewSnippet;
        this.memberType = memberType;
        this.address = address;
    }
}
