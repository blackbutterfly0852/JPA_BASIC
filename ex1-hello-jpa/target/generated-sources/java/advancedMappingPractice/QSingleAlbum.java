package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSingleAlbum is a Querydsl query type for SingleAlbum
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSingleAlbum extends EntityPathBase<SingleAlbum> {

    private static final long serialVersionUID = -360142048L;

    public static final QSingleAlbum singleAlbum = new QSingleAlbum("singleAlbum");

    public final QSingleItem _super = new QSingleItem(this);

    public final StringPath artist = createString("artist");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QSingleAlbum(String variable) {
        super(SingleAlbum.class, forVariable(variable));
    }

    public QSingleAlbum(Path<? extends SingleAlbum> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSingleAlbum(PathMetadata metadata) {
        super(SingleAlbum.class, metadata);
    }

}

