package fixit.model;

public class ContractorsVw
{

    public final int id;
    public final int categoryId;
    public final int subCategoryId;
    public final double hourlyRate;
    public final double overallScore;
    public final MembershipType memberType; //Standard, Premium or whatever
    public final Address address;
    public final String username;
    public final boolean isDeleted;
    public final String imageURL;

    public ContractorsVw(int id,
                         int subCategoryId,
                         double hourlyRate,
                         double overallScore,
                         MembershipType memberType,
                         Address address,
                         String username,
                         boolean isDeleted,
                         String imageURL,
                         int categoryId)
    {
        this.id = id;
        this.subCategoryId = subCategoryId;
        this.hourlyRate = hourlyRate;
        this.overallScore = overallScore;
        this.memberType = memberType;
        this.address = address;
        this.username = username;
        this.isDeleted = isDeleted;
        this.imageURL = imageURL;
        this.categoryId = categoryId;
    }
}
