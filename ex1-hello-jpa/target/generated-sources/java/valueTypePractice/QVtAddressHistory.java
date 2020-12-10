package valueTypePractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVtAddressHistory is a Querydsl query type for VtAddressHistory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVtAddressHistory extends EntityPathBase<VtAddressHistory> {

    private static final long serialVersionUID = -638835002L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVtAddressHistory vtAddressHistory = new QVtAddressHistory("vtAddressHistory");

    public final QVtAddress address;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QVtMember vtMember;

    public QVtAddressHistory(String variable) {
        this(VtAddressHistory.class, forVariable(variable), INITS);
    }

    public QVtAddressHistory(Path<? extends VtAddressHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVtAddressHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVtAddressHistory(PathMetadata metadata, PathInits inits) {
        this(VtAddressHistory.class, metadata, inits);
    }

    public QVtAddressHistory(Class<? extends VtAddressHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QVtAddress(forProperty("address")) : null;
        this.vtMember = inits.isInitialized("vtMember") ? new QVtMember(forProperty("vtMember"), inits.get("vtMember")) : null;
    }

}

