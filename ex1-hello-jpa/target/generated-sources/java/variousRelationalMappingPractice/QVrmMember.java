package variousRelationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVrmMember is a Querydsl query type for VrmMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVrmMember extends EntityPathBase<VrmMember> {

    private static final long serialVersionUID = 884478004L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVrmMember vrmMember = new QVrmMember("vrmMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QVrmLocker locker;

    public final StringPath name = createString("name");

    public final QVrmTeam team;

    public final ListPath<VrmProduct, QVrmProduct> vrmProductList = this.<VrmProduct, QVrmProduct>createList("vrmProductList", VrmProduct.class, QVrmProduct.class, PathInits.DIRECT2);

    public QVrmMember(String variable) {
        this(VrmMember.class, forVariable(variable), INITS);
    }

    public QVrmMember(Path<? extends VrmMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVrmMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVrmMember(PathMetadata metadata, PathInits inits) {
        this(VrmMember.class, metadata, inits);
    }

    public QVrmMember(Class<? extends VrmMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.locker = inits.isInitialized("locker") ? new QVrmLocker(forProperty("locker"), inits.get("locker")) : null;
        this.team = inits.isInitialized("team") ? new QVrmTeam(forProperty("team")) : null;
    }

}

