package fixit.dataloaders.api;

import fixit.model.Review;

import java.sql.Timestamp;
import java.util.List;

public interface IReviewLoader {
    List<Review> getAllReviews(IConnectionProvider connectionProvider, int profileId);
    List<Review> getSnippetReviews(IConnectionProvider connectionProvider, int profileId);
    void addReview(IConnectionProvider connectionProvider, double score, String comment, boolean recommended,
                   int customerId, int profileId, Timestamp creationDate);
    void editReview(IConnectionProvider connectionProvider, int reviewId, double score, String comment, boolean recommended,
                    Timestamp modificationDate);
    void deleteReview(IConnectionProvider connectionProvider, int reviewId);
}
