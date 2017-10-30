package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QAddress is a Querydsl query type for QAddress
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QAddress extends com.mysema.query.sql.RelationalPathBase<QAddress> {

    private static final long serialVersionUID = -1401066977;

    public static final QAddress address = new QAddress("address");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SimplePath<Object> location = createSimple("location", Object.class);

    public final StringPath state = createString("state");

    public final StringPath street = createString("street");

    public final StringPath zipcode = createString("zipcode");

    public final com.mysema.query.sql.PrimaryKey<QAddress> addressPkey = createPrimaryKey(id);

    public QAddress(String variable) {
        super(QAddress.class, forVariable(variable), "public", "address");
        addMetadata();
    }

    public QAddress(String variable, String schema, String table) {
        super(QAddress.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QAddress(Path<? extends QAddress> path) {
        super(path.getType(), path.getMetadata(), "public", "address");
        addMetadata();
    }

    public QAddress(PathMetadata<?> metadata) {
        super(QAddress.class, metadata, "public", "address");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(city, ColumnMetadata.named("city").withIndex(3).ofType(Types.VARCHAR).withSize(30000).notNull());
        addMetadata(country, ColumnMetadata.named("country").withIndex(5).ofType(Types.VARCHAR).withSize(30000).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(location, ColumnMetadata.named("location").withIndex(7).ofType(Types.OTHER).withSize(2147483647).notNull());
        addMetadata(state, ColumnMetadata.named("state").withIndex(4).ofType(Types.VARCHAR).withSize(30000).notNull());
        addMetadata(street, ColumnMetadata.named("street").withIndex(2).ofType(Types.VARCHAR).withSize(300000));
        addMetadata(zipcode, ColumnMetadata.named("zipcode").withIndex(6).ofType(Types.VARCHAR).withSize(30000).notNull());
    }

}

