package proxyPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProxyMember is a Querydsl query type for ProxyMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProxyMember extends EntityPathBase<ProxyMember> {

    private static final long serialVersionUID = -1668115997L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProxyMember proxyMember = new QProxyMember("proxyMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QProxyTeam team;

    public QProxyMember(String variable) {
        this(ProxyMember.class, forVariable(variable), INITS);
    }

    public QProxyMember(Path<? extends ProxyMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProxyMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProxyMember(PathMetadata metadata, PathInits inits) {
        this(ProxyMember.class, metadata, inits);
    }

    public QProxyMember(Class<? extends ProxyMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new QProxyTeam(forProperty("team")) : null;
    }

}

