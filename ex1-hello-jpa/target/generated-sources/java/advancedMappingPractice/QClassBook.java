package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassBook is a Querydsl query type for ClassBook
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClassBook extends EntityPathBase<ClassBook> {

    private static final long serialVersionUID = -804306214L;

    public static final QClassBook classBook = new QClassBook("classBook");

    public final QClassItem _super = new QClassItem(this);

    public final StringPath author = createString("author");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath isbn = createString("isbn");

    //inherited
    public final StringPath name = _super.name;

    //inherited
    public final NumberPath<Integer> price = _super.price;

    public QClassBook(String variable) {
        super(ClassBook.class, forVariable(variable));
    }

    public QClassBook(Path<? extends ClassBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassBook(PathMetadata metadata) {
        super(ClassBook.class, metadata);
    }

}

