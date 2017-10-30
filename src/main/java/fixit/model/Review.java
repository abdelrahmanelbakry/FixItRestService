package fixit.model;


import java.sql.Timestamp;

//@Entity
public class Review
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public final int id;
    public final double score;
    public final String comment;
    public final boolean recommended;
    public final int customerId;
    public final Timestamp createdDate;
    public final Timestamp lastModifiedDate;
    public final boolean isDeleted;

    public Review(int id,
                  double score,
                  String comment,
                  boolean recommended,
                  int customerId,
                  Timestamp createdDate,
                  Timestamp lastModifiedDate,
                  boolean isDeleted)
    {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.recommended = recommended;
        this.customerId = customerId;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.isDeleted = isDeleted;
    }
}
