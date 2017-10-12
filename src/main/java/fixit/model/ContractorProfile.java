package fixit.model;


import java.util.List;

public class ContractorProfile
{
    public final long id;
    public final String name;
    public final int categoryId;
    public final double hourlyRate;
    public final double overallScore;
    public final List<Review> reviews;
    public final Membershiptype memberType; //Standard, Premium or whatever
    public final fixit.model.Address address; //will contain the zip code

    public ContractorProfile(long id,
                             String name,
                             int categoryId,
                             double hourlyRate,
                             double overallScore,
                             List<fixit.model.Review> reviews,
                             fixit.model.Membershiptype memberType,
                             Location location,
                             fixit.model.Address address)
    {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.hourlyRate = hourlyRate;
        this.overallScore = overallScore;
        this.reviews = reviews;
        this.memberType = memberType;
        this.address = address;
    }
}
