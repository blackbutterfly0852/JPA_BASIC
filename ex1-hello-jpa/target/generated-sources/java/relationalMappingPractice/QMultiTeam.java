package relationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultiTeam is a Querydsl query type for MultiTeam
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMultiTeam extends EntityPathBase<MultiTeam> {

    private static final long serialVersionUID = -907928022L;

    public static final QMultiTeam multiTeam = new QMultiTeam("multiTeam");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<MultiMember, QMultiMember> members = this.<MultiMember, QMultiMember>createList("members", MultiMember.class, QMultiMember.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QMultiTeam(String variable) {
        super(MultiTeam.class, forVariable(variable));
    }

    public QMultiTeam(Path<? extends MultiTeam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMultiTeam(PathMetadata metadata) {
        super(MultiTeam.class, metadata);
    }

}

