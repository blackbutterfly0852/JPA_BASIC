package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSingleMovie is a Querydsl query type for SingleMovie
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSingleMovie extends EntityPathBase<SingleMovie> {

    private static final long serialVersionUID = -348951583L;

    public static final QSingleMovie singleMovie = new QSingleMovie("singleMovie");

    public final QSingleItem _super = new QSingleItem(this);

    public final StringPath actor = createString("actor");

    public final StringPath director = createString("director");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QSingleMovie(String variable) {
        super(SingleMovie.class, forVariable(variable));
    }

    public QSingleMovie(Path<? extends SingleMovie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSingleMovie(PathMetadata metadata) {
        super(SingleMovie.class, metadata);
    }

}

