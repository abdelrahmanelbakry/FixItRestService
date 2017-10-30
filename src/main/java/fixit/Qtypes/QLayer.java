package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QLayer is a Querydsl query type for QLayer
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QLayer extends com.mysema.query.sql.RelationalPathBase<QLayer> {

    private static final long serialVersionUID = 1139356220;

    public static final QLayer layer = new QLayer("layer");

    public final NumberPath<Integer> childId = createNumber("childId", Integer.class);

    public final StringPath featureColumn = createString("featureColumn");

    public final NumberPath<Integer> featureType = createNumber("featureType", Integer.class);

    public final NumberPath<Integer> layerId = createNumber("layerId", Integer.class);

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final StringPath schemaName = createString("schemaName");

    public final StringPath tableName = createString("tableName");

    public final NumberPath<Integer> topologyId = createNumber("topologyId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<QLayer> layerPkey = createPrimaryKey(topologyId, layerId);

    public final com.mysema.query.sql.ForeignKey<QTopology> layerTopologyIdFkey = createForeignKey(topologyId, "id");

    public QLayer(String variable) {
        super(QLayer.class, forVariable(variable), "topology", "layer");
        addMetadata();
    }

    public QLayer(String variable, String schema, String table) {
        super(QLayer.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QLayer(Path<? extends QLayer> path) {
        super(path.getType(), path.getMetadata(), "topology", "layer");
        addMetadata();
    }

    public QLayer(PathMetadata<?> metadata) {
        super(QLayer.class, metadata, "topology", "layer");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(childId, ColumnMetadata.named("child_id").withIndex(8).ofType(Types.INTEGER).withSize(10));
        addMetadata(featureColumn, ColumnMetadata.named("feature_column").withIndex(5).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(featureType, ColumnMetadata.named("feature_type").withIndex(6).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(layerId, ColumnMetadata.named("layer_id").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(level, ColumnMetadata.named("level").withIndex(7).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(schemaName, ColumnMetadata.named("schema_name").withIndex(3).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(tableName, ColumnMetadata.named("table_name").withIndex(4).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(topologyId, ColumnMetadata.named("topology_id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

