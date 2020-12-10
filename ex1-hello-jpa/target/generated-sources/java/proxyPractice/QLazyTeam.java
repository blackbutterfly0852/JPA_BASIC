package proxyPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLazyTeam is a Querydsl query type for LazyTeam
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLazyTeam extends EntityPathBase<LazyTeam> {

    private static final long serialVersionUID = -778611050L;

    public static final QLazyTeam lazyTeam = new QLazyTeam("lazyTeam");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QLazyTeam(String variable) {
        super(LazyTeam.class, forVariable(variable));
    }

    public QLazyTeam(Path<? extends LazyTeam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLazyTeam(PathMetadata metadata) {
        super(LazyTeam.class, metadata);
    }

}

