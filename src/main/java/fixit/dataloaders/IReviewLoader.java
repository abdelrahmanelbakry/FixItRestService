package fixit.dataloaders;

import fixit.model.Review;

import java.util.List;

public interface IReviewLoader {
    List<Review> getAllReviews(IConnectionProvider connectionProvider, int profileId);
    List<Review> getSnippetReviews(IConnectionProvider connectionProvider, int profileId);

}
