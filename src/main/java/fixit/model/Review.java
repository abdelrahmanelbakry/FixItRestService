package fixit.model;

public class Review
{
    public final double score;
    public final String comment;
    public final boolean recommended;
    public final int customerId;

    public Review(double score, String comment, boolean recommended, int customerId) {
        this.score = score;
        this.comment = comment;
        this.recommended = recommended;
        this.customerId = customerId;
    }
}
