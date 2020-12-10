package variousRelationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVrmTeam is a Querydsl query type for VrmTeam
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVrmTeam extends EntityPathBase<VrmTeam> {

    private static final long serialVersionUID = -1205574025L;

    public static final QVrmTeam vrmTeam = new QVrmTeam("vrmTeam");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<VrmMember, QVrmMember> memberList = this.<VrmMember, QVrmMember>createList("memberList", VrmMember.class, QVrmMember.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QVrmTeam(String variable) {
        super(VrmTeam.class, forVariable(variable));
    }

    public QVrmTeam(Path<? extends VrmTeam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVrmTeam(PathMetadata metadata) {
        super(VrmTeam.class, metadata);
    }

}

