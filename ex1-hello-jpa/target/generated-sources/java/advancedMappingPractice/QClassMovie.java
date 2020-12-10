package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassMovie is a Querydsl query type for ClassMovie
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClassMovie extends EntityPathBase<ClassMovie> {

    private static final long serialVersionUID = 846476639L;

    public static final QClassMovie classMovie = new QClassMovie("classMovie");

    public final QClassItem _super = new QClassItem(this);

    public final StringPath actor = createString("actor");

    public final StringPath director = createString("director");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QClassMovie(String variable) {
        super(ClassMovie.class, forVariable(variable));
    }

    public QClassMovie(Path<? extends ClassMovie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassMovie(PathMetadata metadata) {
        super(ClassMovie.class, metadata);
    }

}

