package mappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSequenceMember is a Querydsl query type for SequenceMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSequenceMember extends EntityPathBase<SequenceMember> {

    private static final long serialVersionUID = 1535276608L;

    public static final QSequenceMember sequenceMember = new QSequenceMember("sequenceMember");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath userName = createString("userName");

    public QSequenceMember(String variable) {
        super(SequenceMember.class, forVariable(variable));
    }

    public QSequenceMember(Path<? extends SequenceMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSequenceMember(PathMetadata metadata) {
        super(SequenceMember.class, metadata);
    }

}

