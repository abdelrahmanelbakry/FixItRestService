package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QRasterOverviews is a Querydsl query type for QRasterOverviews
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QRasterOverviews extends com.mysema.query.sql.RelationalPathBase<QRasterOverviews> {

    private static final long serialVersionUID = 1085656136;

    public static final QRasterOverviews rasterOverviews = new QRasterOverviews("raster_overviews");

    public final StringPath oRasterColumn = createString("oRasterColumn");

    public final StringPath oTableCatalog = createString("oTableCatalog");

    public final StringPath oTableName = createString("oTableName");

    public final StringPath oTableSchema = createString("oTableSchema");

    public final NumberPath<Integer> overviewFactor = createNumber("overviewFactor", Integer.class);

    public final StringPath rRasterColumn = createString("rRasterColumn");

    public final StringPath rTableCatalog = createString("rTableCatalog");

    public final StringPath rTableName = createString("rTableName");

    public final StringPath rTableSchema = createString("rTableSchema");

    public QRasterOverviews(String variable) {
        super(QRasterOverviews.class, forVariable(variable), "public", "raster_overviews");
        addMetadata();
    }

    public QRasterOverviews(String variable, String schema, String table) {
        super(QRasterOverviews.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QRasterOverviews(Path<? extends QRasterOverviews> path) {
        super(path.getType(), path.getMetadata(), "public", "raster_overviews");
        addMetadata();
    }

    public QRasterOverviews(PathMetadata<?> metadata) {
        super(QRasterOverviews.class, metadata, "public", "raster_overviews");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(oRasterColumn, ColumnMetadata.named("o_raster_column").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(oTableCatalog, ColumnMetadata.named("o_table_catalog").withIndex(1).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(oTableName, ColumnMetadata.named("o_table_name").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(oTableSchema, ColumnMetadata.named("o_table_schema").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(overviewFactor, ColumnMetadata.named("overview_factor").withIndex(9).ofType(Types.INTEGER).withSize(10));
        addMetadata(rRasterColumn, ColumnMetadata.named("r_raster_column").withIndex(8).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(rTableCatalog, ColumnMetadata.named("r_table_catalog").withIndex(5).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(rTableName, ColumnMetadata.named("r_table_name").withIndex(7).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(rTableSchema, ColumnMetadata.named("r_table_schema").withIndex(6).ofType(Types.VARCHAR).withSize(2147483647));
    }

}

