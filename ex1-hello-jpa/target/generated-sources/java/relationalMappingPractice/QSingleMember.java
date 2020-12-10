package relationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSingleMember is a Querydsl query type for SingleMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSingleMember extends EntityPathBase<SingleMember> {

    private static final long serialVersionUID = -2024670834L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSingleMember singleMember = new QSingleMember("singleMember");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QSingleTeam team;

    public QSingleMember(String variable) {
        this(SingleMember.class, forVariable(variable), INITS);
    }

    public QSingleMember(Path<? extends SingleMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSingleMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSingleMember(PathMetadata metadata, PathInits inits) {
        this(SingleMember.class, metadata, inits);
    }

    public QSingleMember(Class<? extends SingleMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.team = inits.isInitialized("team") ? new QSingleTeam(forProperty("team")) : null;
    }

}

