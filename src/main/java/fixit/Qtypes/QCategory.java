package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QCategory is a Querydsl query type for QCategory
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QCategory extends com.mysema.query.sql.RelationalPathBase<QCategory> {

    private static final long serialVersionUID = 785822771;

    public static final QCategory category = new QCategory("category");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.mysema.query.sql.PrimaryKey<QCategory> categoryPkey = createPrimaryKey(id);

    public QCategory(String variable) {
        super(QCategory.class, forVariable(variable), "public", "category");
        addMetadata();
    }

    public QCategory(String variable, String schema, String table) {
        super(QCategory.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QCategory(Path<? extends QCategory> path) {
        super(path.getType(), path.getMetadata(), "public", "category");
        addMetadata();
    }

    public QCategory(PathMetadata<?> metadata) {
        super(QCategory.class, metadata, "public", "category");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(3000).notNull());
    }

}

