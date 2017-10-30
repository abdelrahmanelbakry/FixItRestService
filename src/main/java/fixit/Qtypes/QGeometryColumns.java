package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QGeometryColumns is a Querydsl query type for QGeometryColumns
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QGeometryColumns extends com.mysema.query.sql.RelationalPathBase<QGeometryColumns> {

    private static final long serialVersionUID = 1429182006;

    public static final QGeometryColumns geometryColumns = new QGeometryColumns("geometry_columns");

    public final NumberPath<Integer> coordDimension = createNumber("coordDimension", Integer.class);

    public final StringPath fGeometryColumn = createString("fGeometryColumn");

    public final StringPath fTableCatalog = createString("fTableCatalog");

    public final StringPath fTableName = createString("fTableName");

    public final StringPath fTableSchema = createString("fTableSchema");

    public final NumberPath<Integer> srid = createNumber("srid", Integer.class);

    public final StringPath type = createString("type");

    public QGeometryColumns(String variable) {
        super(QGeometryColumns.class, forVariable(variable), "public", "geometry_columns");
        addMetadata();
    }

    public QGeometryColumns(String variable, String schema, String table) {
        super(QGeometryColumns.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QGeometryColumns(Path<? extends QGeometryColumns> path) {
        super(path.getType(), path.getMetadata(), "public", "geometry_columns");
        addMetadata();
    }

    public QGeometryColumns(PathMetadata<?> metadata) {
        super(QGeometryColumns.class, metadata, "public", "geometry_columns");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(coordDimension, ColumnMetadata.named("coord_dimension").withIndex(5).ofType(Types.INTEGER).withSize(10));
        addMetadata(fGeometryColumn, ColumnMetadata.named("f_geometry_column").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fTableCatalog, ColumnMetadata.named("f_table_catalog").withIndex(1).ofType(Types.VARCHAR).withSize(256));
        addMetadata(fTableName, ColumnMetadata.named("f_table_name").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(fTableSchema, ColumnMetadata.named("f_table_schema").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(srid, ColumnMetadata.named("srid").withIndex(6).ofType(Types.INTEGER).withSize(10));
        addMetadata(type, ColumnMetadata.named("type").withIndex(7).ofType(Types.VARCHAR).withSize(30));
    }

}

