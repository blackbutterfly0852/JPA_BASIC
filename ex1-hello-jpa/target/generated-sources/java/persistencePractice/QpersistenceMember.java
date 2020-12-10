package persistencePractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QpersistenceMember is a Querydsl query type for persistenceMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QpersistenceMember extends EntityPathBase<persistenceMember> {

    private static final long serialVersionUID = -1250937307L;

    public static final QpersistenceMember persistenceMember = new QpersistenceMember("persistenceMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QpersistenceMember(String variable) {
        super(persistenceMember.class, forVariable(variable));
    }

    public QpersistenceMember(Path<? extends persistenceMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QpersistenceMember(PathMetadata metadata) {
        super(persistenceMember.class, metadata);
    }

}

