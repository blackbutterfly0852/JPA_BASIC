package valueTypePractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVtMember is a Querydsl query type for VtMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVtMember extends EntityPathBase<VtMember> {

    private static final long serialVersionUID = -1420062368L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVtMember vtMember = new QVtMember("vtMember");

    public final ListPath<VtAddressHistory, QVtAddressHistory> addressHistory = this.<VtAddressHistory, QVtAddressHistory>createList("addressHistory", VtAddressHistory.class, QVtAddressHistory.class, PathInits.DIRECT2);

    public final SetPath<String, StringPath> favoriteFoods = this.<String, StringPath>createSet("favoriteFoods", String.class, StringPath.class, PathInits.DIRECT2);

    public final QVtAddress homeAddress;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QVtAddress workAddress;

    public final QVtPeriod workPeriod;

    public QVtMember(String variable) {
        this(VtMember.class, forVariable(variable), INITS);
    }

    public QVtMember(Path<? extends VtMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVtMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVtMember(PathMetadata metadata, PathInits inits) {
        this(VtMember.class, metadata, inits);
    }

    public QVtMember(Class<? extends VtMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.homeAddress = inits.isInitialized("homeAddress") ? new QVtAddress(forProperty("homeAddress")) : null;
        this.workAddress = inits.isInitialized("workAddress") ? new QVtAddress(forProperty("workAddress")) : null;
        this.workPeriod = inits.isInitialized("workPeriod") ? new QVtPeriod(forProperty("workPeriod")) : null;
    }

}

