package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClassItem is a Querydsl query type for ClassItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClassItem extends EntityPathBase<ClassItem> {

    private static final long serialVersionUID = -804093180L;

    public static final QClassItem classItem = new QClassItem("classItem");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public QClassItem(String variable) {
        super(ClassItem.class, forVariable(variable));
    }

    public QClassItem(Path<? extends ClassItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClassItem(PathMetadata metadata) {
        super(ClassItem.class, metadata);
    }

}

