package fixit.dataloaders;

import fixit.Qtypes.QContractorprofile;
import fixit.Qtypes.QReview;
import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.Projections;

import fixit.model.Review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReviewLoader implements IReviewLoader {
    QReview reviewtb = QReview.review;
    QContractorprofile contractorProfiletb = QContractorprofile.contractorprofile;

    @Override
    public List<Review> getAllReviews(IConnectionProvider connectionProvider, int profileId) {
        List<Review> reviews = new ArrayList<>();
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            reviews = query.from(reviewtb)
                    .innerJoin(contractorProfiletb)
                    .where(contractorProfiletb.id.eq(profileId)
                        .and(reviewtb.id.in((Collection<Integer>) contractorProfiletb.reviewids)))
                    .list(mapReviews());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public List<Review> getSnippetReviews(IConnectionProvider connectionProvider, int profileId) {
        List<Review> reviews = new ArrayList<>();
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            SQLQuery query = new SQLQuery( connectionProvider.getConnection(), dialect);
            reviews = query.from(reviewtb)
                    .innerJoin(contractorProfiletb)
                    .where(contractorProfiletb.id.eq(profileId)
                        .and(reviewtb.id.in((Collection<Integer>) contractorProfiletb.reviewids)))
                    .orderBy(reviewtb.lastupdateddate.desc())
                    .limit(3)
                    .list(mapReviews());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    private FactoryExpression<Review> mapReviews() {
        return Projections.constructor(Review.class,
                reviewtb.id,
                reviewtb.comment);
    }
}
