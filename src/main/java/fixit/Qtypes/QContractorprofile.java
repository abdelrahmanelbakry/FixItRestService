package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QContractorprofile is a Querydsl query type for QContractorprofile
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QContractorprofile extends com.mysema.query.sql.RelationalPathBase<QContractorprofile> {

    private static final long serialVersionUID = -1249968641;

    public static final QContractorprofile contractorprofile = new QContractorprofile("contractorprofile");

    public final NumberPath<Integer> addressid = createNumber("addressid", Integer.class);

    public final NumberPath<Integer> categoryid = createNumber("categoryid", Integer.class);

    public final NumberPath<Integer> contactinfoid = createNumber("contactinfoid", Integer.class);

    public final NumberPath<Double> hourlyrate = createNumber("hourlyrate", Double.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> memebershiptype = createNumber("memebershiptype", Integer.class);

    public final NumberPath<Double> overallscore = createNumber("overallscore", Double.class);

    public final SimplePath<Integer[]> reviewids = createSimple("reviewids", Integer[].class);

    public final com.mysema.query.sql.PrimaryKey<QContractorprofile> contractorprofilePkey = createPrimaryKey(id);

    public QContractorprofile(String variable) {
        super(QContractorprofile.class, forVariable(variable), "public", "contractorprofile");
        addMetadata();
    }

    public QContractorprofile(String variable, String schema, String table) {
        super(QContractorprofile.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QContractorprofile(Path<? extends QContractorprofile> path) {
        super(path.getType(), path.getMetadata(), "public", "contractorprofile");
        addMetadata();
    }

    public QContractorprofile(PathMetadata<?> metadata) {
        super(QContractorprofile.class, metadata, "public", "contractorprofile");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(addressid, ColumnMetadata.named("addressid").withIndex(7).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(categoryid, ColumnMetadata.named("categoryid").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(contactinfoid, ColumnMetadata.named("contactinfoid").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(hourlyrate, ColumnMetadata.named("hourlyrate").withIndex(3).ofType(Types.DOUBLE).withSize(17).withDigits(17));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(memebershiptype, ColumnMetadata.named("memebershiptype").withIndex(6).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(overallscore, ColumnMetadata.named("overallscore").withIndex(4).ofType(Types.DOUBLE).withSize(17).withDigits(17).notNull());
        addMetadata(reviewids, ColumnMetadata.named("reviewids").withIndex(8).ofType(Types.ARRAY).withSize(10));
    }

}

