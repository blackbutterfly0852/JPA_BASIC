package mappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIdentityMember is a Querydsl query type for IdentityMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIdentityMember extends EntityPathBase<IdentityMember> {

    private static final long serialVersionUID = -1633092227L;

    public static final QIdentityMember identityMember = new QIdentityMember("identityMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath userName = createString("userName");

    public QIdentityMember(String variable) {
        super(IdentityMember.class, forVariable(variable));
    }

    public QIdentityMember(Path<? extends IdentityMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIdentityMember(PathMetadata metadata) {
        super(IdentityMember.class, metadata);
    }

}

