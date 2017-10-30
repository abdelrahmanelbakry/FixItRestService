package fixit.Qtypes;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTopology is a Querydsl query type for QTopology
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QTopology extends com.mysema.query.sql.RelationalPathBase<QTopology> {

    private static final long serialVersionUID = -216155740;

    public static final QTopology topology = new QTopology("topology");

    public final BooleanPath hasz = createBoolean("hasz");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> precision = createNumber("precision", Double.class);

    public final NumberPath<Integer> srid = createNumber("srid", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<QTopology> topologyPkey = createPrimaryKey(id);

    public final com.mysema.query.sql.ForeignKey<QLayer> _layerTopologyIdFkey = createInvForeignKey(id, "topology_id");

    public QTopology(String variable) {
        super(QTopology.class, forVariable(variable), "topology", "topology");
        addMetadata();
    }

    public QTopology(String variable, String schema, String table) {
        super(QTopology.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTopology(Path<? extends QTopology> path) {
        super(path.getType(), path.getMetadata(), "topology", "topology");
        addMetadata();
    }

    public QTopology(PathMetadata<?> metadata) {
        super(QTopology.class, metadata, "topology", "topology");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(hasz, ColumnMetadata.named("hasz").withIndex(5).ofType(Types.BIT).withSize(1).notNull());
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647).notNull());
        addMetadata(precision, ColumnMetadata.named("precision").withIndex(4).ofType(Types.DOUBLE).withSize(17).withDigits(17).notNull());
        addMetadata(srid, ColumnMetadata.named("srid").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

