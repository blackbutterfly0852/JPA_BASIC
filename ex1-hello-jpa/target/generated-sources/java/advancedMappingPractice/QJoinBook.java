package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJoinBook is a Querydsl query type for JoinBook
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJoinBook extends EntityPathBase<JoinBook> {

    private static final long serialVersionUID = 234672570L;

    public static final QJoinBook joinBook = new QJoinBook("joinBook");

    public final QJoinItem _super = new QJoinItem(this);

    public final StringPath author = createString("author");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath isbn = createString("isbn");

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QJoinBook(String variable) {
        super(JoinBook.class, forVariable(variable));
    }

    public QJoinBook(Path<? extends JoinBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJoinBook(PathMetadata metadata) {
        super(JoinBook.class, metadata);
    }

}

