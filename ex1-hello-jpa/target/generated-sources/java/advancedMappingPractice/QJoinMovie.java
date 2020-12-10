package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJoinMovie is a Querydsl query type for JoinMovie
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJoinMovie extends EntityPathBase<JoinMovie> {

    private static final long serialVersionUID = -1304919425L;

    public static final QJoinMovie joinMovie = new QJoinMovie("joinMovie");

    public final QJoinItem _super = new QJoinItem(this);

    public final StringPath actor = createString("actor");

    public final StringPath director = createString("director");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QJoinMovie(String variable) {
        super(JoinMovie.class, forVariable(variable));
    }

    public QJoinMovie(Path<? extends JoinMovie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJoinMovie(PathMetadata metadata) {
        super(JoinMovie.class, metadata);
    }

}

