package persistencePractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember_3 is a Querydsl query type for Member_3
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember_3 extends EntityPathBase<Member_3> {

    private static final long serialVersionUID = 667618914L;

    public static final QMember_3 member_3 = new QMember_3("member_3");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath userName = createString("userName");

    public QMember_3(String variable) {
        super(Member_3.class, forVariable(variable));
    }

    public QMember_3(Path<? extends Member_3> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember_3(PathMetadata metadata) {
        super(Member_3.class, metadata);
    }

}

