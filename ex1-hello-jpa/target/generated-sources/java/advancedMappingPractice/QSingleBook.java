package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSingleBook is a Querydsl query type for SingleBook
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSingleBook extends EntityPathBase<SingleBook> {

    private static final long serialVersionUID = 2066625560L;

    public static final QSingleBook singleBook = new QSingleBook("singleBook");

    public final QSingleItem _super = new QSingleItem(this);

    public final StringPath author = createString("author");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath isbn = createString("isbn");

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QSingleBook(String variable) {
        super(SingleBook.class, forVariable(variable));
    }

    public QSingleBook(Path<? extends SingleBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSingleBook(PathMetadata metadata) {
        super(SingleBook.class, metadata);
    }

}

