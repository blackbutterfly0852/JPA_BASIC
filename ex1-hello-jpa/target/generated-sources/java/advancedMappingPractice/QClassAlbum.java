package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassAlbum is a Querydsl query type for ClassAlbum
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClassAlbum extends EntityPathBase<ClassAlbum> {

    private static final long serialVersionUID = 835286174L;

    public static final QClassAlbum classAlbum = new QClassAlbum("classAlbum");

    public final QClassItem _super = new QClassItem(this);

    public final StringPath artist = createString("artist");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QClassAlbum(String variable) {
        super(ClassAlbum.class, forVariable(variable));
    }

    public QClassAlbum(Path<? extends ClassAlbum> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassAlbum(PathMetadata metadata) {
        super(ClassAlbum.class, metadata);
    }

}

