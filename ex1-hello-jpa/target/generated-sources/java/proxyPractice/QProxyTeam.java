package proxyPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProxyTeam is a Querydsl query type for ProxyTeam
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProxyTeam extends EntityPathBase<ProxyTeam> {

    private static final long serialVersionUID = 1388414950L;

    public static final QProxyTeam proxyTeam = new QProxyTeam("proxyTeam");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QProxyTeam(String variable) {
        super(ProxyTeam.class, forVariable(variable));
    }

    public QProxyTeam(Path<? extends ProxyTeam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProxyTeam(PathMetadata metadata) {
        super(ProxyTeam.class, metadata);
    }

}

