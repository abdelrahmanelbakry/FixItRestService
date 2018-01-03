package fixit.dataloaders.impls;

import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.mysema.query.sql.dml.SQLInsertClause;
import com.mysema.query.sql.dml.SQLUpdateClause;
import fixit.Qtypes.QContractorprofile;
import fixit.Qtypes.QReview;
import com.mysema.query.sql.HSQLDBTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.Projections;

import fixit.dataloaders.api.IConnectionProvider;
import fixit.dataloaders.api.IReviewLoader;
import fixit.model.Review;

import java.sql.SQLException;
import java.sql.Timestamp;
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
                        .and(reviewtb.id.in((Collection<Integer>) contractorProfiletb.reviewids))
                        .and(reviewtb.isdeleted.isFalse()))
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
                        .and(reviewtb.id.in((Collection<Integer>) contractorProfiletb.reviewids))
                        .and(reviewtb.isdeleted.isFalse()))
                    .orderBy(reviewtb.lastupdateddate.desc())
                    .limit(3)
                    .list(mapReviews());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public void addReview(IConnectionProvider connectionProvider,
                          double score,
                          String comment,
                          boolean recommended,
                          int customerId,
                          int profileId,
                          Timestamp creationDate) {
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            new SQLInsertClause(connectionProvider.getConnection(), dialect, reviewtb)
                    .values(comment, score, recommended, customerId, creationDate,
                            creationDate, false, profileId)
                    .execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editReview(IConnectionProvider connectionProvider,
                           int reviewId,
                           double score,
                           String comment,
                           boolean recommended,
                           Timestamp modificationDate) {
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            new SQLUpdateClause(connectionProvider.getConnection(), dialect, reviewtb)
                    .set(reviewtb.comment, comment)
                    .set(reviewtb.score, score)
                    .set(reviewtb.recommend, recommended)
                    .set(reviewtb.lastupdateddate, new Timestamp(System.currentTimeMillis()))
                    .where(reviewtb.id.eq(reviewId))
                    .execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReview(IConnectionProvider connectionProvider, int reviewId) {
        try {
            SQLTemplates dialect = new HSQLDBTemplates();
            new SQLUpdateClause(connectionProvider.getConnection(), dialect, reviewtb)
                    .set(reviewtb.isdeleted, true)
                    .set(reviewtb.lastupdateddate, new Timestamp(System.currentTimeMillis()))
                    .where(reviewtb.id.eq(reviewId))
                    .execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private FactoryExpression<Review> mapReviews() {
        return Projections.constructor(Review.class,
                reviewtb.id,
                reviewtb.score,
                reviewtb.comment,
                reviewtb.recommend,
                reviewtb.customerid,
                reviewtb.createddate,
                reviewtb.lastupdateddate,
                reviewtb.isdeleted,
                reviewtb.profileid);
    }
}
