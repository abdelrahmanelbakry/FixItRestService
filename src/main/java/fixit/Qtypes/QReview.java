package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QReview is a Querydsl query type for QReview
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QReview extends com.mysema.query.sql.RelationalPathBase<QReview> {

    private static final long serialVersionUID = 1135687629;

    public static final QReview review = new QReview("review");

    public final StringPath comment = createString("comment");

    public final DateTimePath<java.sql.Timestamp> createddate = createDateTime("createddate", java.sql.Timestamp.class);

    public final NumberPath<Integer> customerid = createNumber("customerid", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isdeleted = createBoolean("isdeleted");

    public final DateTimePath<java.sql.Timestamp> lastupdateddate = createDateTime("lastupdateddate", java.sql.Timestamp.class);

    public final NumberPath<Integer> profileid = createNumber("profileid", Integer.class);

    public final BooleanPath recommend = createBoolean("recommend");

    public final NumberPath<Double> score = createNumber("score", Double.class);

    public final com.mysema.query.sql.PrimaryKey<QReview> reviewPkey = createPrimaryKey(id);

    public QReview(String variable) {
        super(QReview.class, forVariable(variable), "public", "review");
        addMetadata();
    }

    public QReview(String variable, String schema, String table) {
        super(QReview.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QReview(Path<? extends QReview> path) {
        super(path.getType(), path.getMetadata(), "public", "review");
        addMetadata();
    }

    public QReview(PathMetadata<?> metadata) {
        super(QReview.class, metadata, "public", "review");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(comment, ColumnMetadata.named("comment").withIndex(2).ofType(Types.VARCHAR).withSize(3000000));
        addMetadata(createddate, ColumnMetadata.named("createddate").withIndex(6).ofType(Types.TIMESTAMP).withSize(35).withDigits(6).notNull());
        addMetadata(customerid, ColumnMetadata.named("customerid").withIndex(5).ofType(Types.INTEGER).withSize(10));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(isdeleted, ColumnMetadata.named("isdeleted").withIndex(8).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(lastupdateddate, ColumnMetadata.named("lastupdateddate").withIndex(7).ofType(Types.TIMESTAMP).withSize(35).withDigits(6).notNull());
        addMetadata(profileid, ColumnMetadata.named("profileid").withIndex(9).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(recommend, ColumnMetadata.named("recommend").withIndex(4).ofType(Types.BIT).withSize(1));
        addMetadata(score, ColumnMetadata.named("score").withIndex(3).ofType(Types.DOUBLE).withSize(17).withDigits(17).notNull());
    }

}

