package variousRelationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVrmLocker is a Querydsl query type for VrmLocker
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVrmLocker extends EntityPathBase<VrmLocker> {

    private static final long serialVersionUID = 864794802L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVrmLocker vrmLocker = new QVrmLocker("vrmLocker");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QVrmMember member;

    public final StringPath name = createString("name");

    public QVrmLocker(String variable) {
        this(VrmLocker.class, forVariable(variable), INITS);
    }

    public QVrmLocker(Path<? extends VrmLocker> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVrmLocker(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVrmLocker(PathMetadata metadata, PathInits inits) {
        this(VrmLocker.class, metadata, inits);
    }

    public QVrmLocker(Class<? extends VrmLocker> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QVrmMember(forProperty("member"), inits.get("member")) : null;
    }

}

