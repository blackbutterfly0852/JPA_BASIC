package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJoinAlbum is a Querydsl query type for JoinAlbum
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJoinAlbum extends EntityPathBase<JoinAlbum> {

    private static final long serialVersionUID = -1316109890L;

    public static final QJoinAlbum joinAlbum = new QJoinAlbum("joinAlbum");

    public final QJoinItem _super = new QJoinItem(this);

    public final StringPath artist = createString("artist");

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QJoinAlbum(String variable) {
        super(JoinAlbum.class, forVariable(variable));
    }

    public QJoinAlbum(Path<? extends JoinAlbum> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJoinAlbum(PathMetadata metadata) {
        super(JoinAlbum.class, metadata);
    }

}

