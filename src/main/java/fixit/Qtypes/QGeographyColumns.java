package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QGeographyColumns is a Querydsl query type for QGeographyColumns
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QGeographyColumns extends com.mysema.query.sql.RelationalPathBase<QGeographyColumns> {

    private static final long serialVersionUID = 640648950;

    public static final QGeographyColumns geographyColumns = new QGeographyColumns("geography_columns");

    public final NumberPath<Integer> coordDimension = createNumber("coordDimension", Integer.class);

    public final StringPath fGeographyColumn = createString("fGeographyColumn");

    public final StringPath fTableCatalog = createString("fTableCatalog");

    public final StringPath fTableName = createString("fTableName");

    public final StringPath fTableSchema = createString("fTableSchema");

    public final NumberPath<Integer> srid = createNumber("srid", Integer.class);

    public final StringPath type = createString("type");

    public QGeographyColumns(String variable) {
        super(QGeographyColumns.class, forVariable(variable), "public", "geography_columns");
        addMetadata();
    }

    public QGeographyColumns(String variable, String schema, String table) {
        super(QGeographyColumns.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QGeographyColumns(Path<? extends QGeographyColumns> path) {
        super(path.getType(), path.getMetadata(), "public", "geography_columns");
        addMetadata();
    }

    public QGeographyColumns(PathMetadata<?> metadata) {
        super(QGeographyColumns.class, metadata, "public", "geography_columns");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(coordDimension, ColumnMetadata.named("coord_dimension").withIndex(5).ofType(Types.INTEGER).withSize(10));
        addMetadata(fGeographyColumn, ColumnMetadata.named("f_geography_column").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fTableCatalog, ColumnMetadata.named("f_table_catalog").withIndex(1).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fTableName, ColumnMetadata.named("f_table_name").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fTableSchema, ColumnMetadata.named("f_table_schema").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(srid, ColumnMetadata.named("srid").withIndex(6).ofType(Types.INTEGER).withSize(10));
        addMetadata(type, ColumnMetadata.named("type").withIndex(7).ofType(Types.VARCHAR).withSize(2147483647));
    }

}

