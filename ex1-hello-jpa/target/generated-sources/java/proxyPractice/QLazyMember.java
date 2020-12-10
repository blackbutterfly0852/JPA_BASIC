package proxyPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLazyMember is a Querydsl query type for LazyMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLazyMember extends EntityPathBase<LazyMember> {

    private static final long serialVersionUID = -1120963437L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLazyMember lazyMember = new QLazyMember("lazyMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QLazyTeam team;

    public QLazyMember(String variable) {
        this(LazyMember.class, forVariable(variable), INITS);
    }

    public QLazyMember(Path<? extends LazyMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLazyMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLazyMember(PathMetadata metadata, PathInits inits) {
        this(LazyMember.class, metadata, inits);
    }

    public QLazyMember(Class<? extends LazyMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new QLazyTeam(forProperty("team")) : null;
    }

}

