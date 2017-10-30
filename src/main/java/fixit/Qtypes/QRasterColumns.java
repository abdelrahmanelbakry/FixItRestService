package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QRasterColumns is a Querydsl query type for QRasterColumns
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QRasterColumns extends com.mysema.query.sql.RelationalPathBase<QRasterColumns> {

    private static final long serialVersionUID = 692409739;

    public static final QRasterColumns rasterColumns = new QRasterColumns("raster_columns");

    public final NumberPath<Integer> blocksizeX = createNumber("blocksizeX", Integer.class);

    public final NumberPath<Integer> blocksizeY = createNumber("blocksizeY", Integer.class);

    public final SimplePath<Object> extent = createSimple("extent", Object.class);

    public final SimplePath<Double[]> nodataValues = createSimple("nodataValues", Double[].class);

    public final NumberPath<Integer> numBands = createNumber("numBands", Integer.class);

    public final SimplePath<Boolean[]> outDb = createSimple("outDb", Boolean[].class);

    public final SimplePath<String[]> pixelTypes = createSimple("pixelTypes", String[].class);

    public final BooleanPath regularBlocking = createBoolean("regularBlocking");

    public final StringPath rRasterColumn = createString("rRasterColumn");

    public final StringPath rTableCatalog = createString("rTableCatalog");

    public final StringPath rTableName = createString("rTableName");

    public final StringPath rTableSchema = createString("rTableSchema");

    public final BooleanPath sameAlignment = createBoolean("sameAlignment");

    public final NumberPath<Double> scaleX = createNumber("scaleX", Double.class);

    public final NumberPath<Double> scaleY = createNumber("scaleY", Double.class);

    public final BooleanPath spatialIndex = createBoolean("spatialIndex");

    public final NumberPath<Integer> srid = createNumber("srid", Integer.class);

    public QRasterColumns(String variable) {
        super(QRasterColumns.class, forVariable(variable), "public", "raster_columns");
        addMetadata();
    }

    public QRasterColumns(String variable, String schema, String table) {
        super(QRasterColumns.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QRasterColumns(Path<? extends QRasterColumns> path) {
        super(path.getType(), path.getMetadata(), "public", "raster_columns");
        addMetadata();
    }

    public QRasterColumns(PathMetadata<?> metadata) {
        super(QRasterColumns.class, metadata, "public", "raster_columns");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(blocksizeX, ColumnMetadata.named("blocksize_x").withIndex(8).ofType(Types.INTEGER).withSize(10));
        addMetadata(blocksizeY, ColumnMetadata.named("blocksize_y").withIndex(9).ofType(Types.INTEGER).withSize(10));
        addMetadata(extent, ColumnMetadata.named("extent").withIndex(16).ofType(Types.OTHER).withSize(2147483647));
        addMetadata(nodataValues, ColumnMetadata.named("nodata_values").withIndex(14).ofType(Types.ARRAY).withSize(17).withDigits(17));
        addMetadata(numBands, ColumnMetadata.named("num_bands").withIndex(12).ofType(Types.INTEGER).withSize(10));
        addMetadata(outDb, ColumnMetadata.named("out_db").withIndex(15).ofType(Types.ARRAY).withSize(1));
        addMetadata(pixelTypes, ColumnMetadata.named("pixel_types").withIndex(13).ofType(Types.ARRAY).withSize(2147483647));
        addMetadata(regularBlocking, ColumnMetadata.named("regular_blocking").withIndex(11).ofType(Types.BIT).withSize(1));
        addMetadata(rRasterColumn, ColumnMetadata.named("r_raster_column").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(rTableCatalog, ColumnMetadata.named("r_table_catalog").withIndex(1).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(rTableName, ColumnMetadata.named("r_table_name").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(rTableSchema, ColumnMetadata.named("r_table_schema").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647));
        addMetadata(sameAlignment, ColumnMetadata.named("same_alignment").withIndex(10).ofType(Types.BIT).withSize(1));
        addMetadata(scaleX, ColumnMetadata.named("scale_x").withIndex(6).ofType(Types.DOUBLE).withSize(17).withDigits(17));
        addMetadata(scaleY, ColumnMetadata.named("scale_y").withIndex(7).ofType(Types.DOUBLE).withSize(17).withDigits(17));
        addMetadata(spatialIndex, ColumnMetadata.named("spatial_index").withIndex(17).ofType(Types.BIT).withSize(1));
        addMetadata(srid, ColumnMetadata.named("srid").withIndex(5).ofType(Types.INTEGER).withSize(10));
    }

}

