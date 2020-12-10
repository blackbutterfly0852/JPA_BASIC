package relationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSingleTeam is a Querydsl query type for SingleTeam
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSingleTeam extends EntityPathBase<SingleTeam> {

    private static final long serialVersionUID = 1593630289L;

    public static final QSingleTeam singleTeam = new QSingleTeam("singleTeam");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QSingleTeam(String variable) {
        super(SingleTeam.class, forVariable(variable));
    }

    public QSingleTeam(Path<? extends SingleTeam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSingleTeam(PathMetadata metadata) {
        super(SingleTeam.class, metadata);
    }

}

