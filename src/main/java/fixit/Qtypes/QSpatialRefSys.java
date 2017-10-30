package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QSpatialRefSys is a Querydsl query type for QSpatialRefSys
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QSpatialRefSys extends com.mysema.query.sql.RelationalPathBase<QSpatialRefSys> {

    private static final long serialVersionUID = -986490551;

    public static final QSpatialRefSys spatialRefSys = new QSpatialRefSys("spatial_ref_sys");

    public final StringPath authName = createString("authName");

    public final NumberPath<Integer> authSrid = createNumber("authSrid", Integer.class);

    public final StringPath proj4text = createString("proj4text");

    public final NumberPath<Integer> srid = createNumber("srid", Integer.class);

    public final StringPath srtext = createString("srtext");

    public final com.mysema.query.sql.PrimaryKey<QSpatialRefSys> spatialRefSysPkey = createPrimaryKey(srid);

    public QSpatialRefSys(String variable) {
        super(QSpatialRefSys.class, forVariable(variable), "public", "spatial_ref_sys");
        addMetadata();
    }

    public QSpatialRefSys(String variable, String schema, String table) {
        super(QSpatialRefSys.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QSpatialRefSys(Path<? extends QSpatialRefSys> path) {
        super(path.getType(), path.getMetadata(), "public", "spatial_ref_sys");
        addMetadata();
    }

    public QSpatialRefSys(PathMetadata<?> metadata) {
        super(QSpatialRefSys.class, metadata, "public", "spatial_ref_sys");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(authName, ColumnMetadata.named("auth_name").withIndex(2).ofType(Types.VARCHAR).withSize(256));
        addMetadata(authSrid, ColumnMetadata.named("auth_srid").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(proj4text, ColumnMetadata.named("proj4text").withIndex(5).ofType(Types.VARCHAR).withSize(2048));
        addMetadata(srid, ColumnMetadata.named("srid").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(srtext, ColumnMetadata.named("srtext").withIndex(4).ofType(Types.VARCHAR).withSize(2048));
    }

}

