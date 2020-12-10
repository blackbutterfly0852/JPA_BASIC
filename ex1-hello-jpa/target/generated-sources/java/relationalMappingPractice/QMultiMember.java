package relationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiMember is a Querydsl query type for MultiMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMultiMember extends EntityPathBase<MultiMember> {

    private static final long serialVersionUID = -840521945L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultiMember multiMember = new QMultiMember("multiMember");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QMultiTeam team;

    public QMultiMember(String variable) {
        this(MultiMember.class, forVariable(variable), INITS);
    }

    public QMultiMember(Path<? extends MultiMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultiMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultiMember(PathMetadata metadata, PathInits inits) {
        this(MultiMember.class, metadata, inits);
    }

    public QMultiMember(Class<? extends MultiMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new QMultiTeam(forProperty("team")) : null;
    }

}

