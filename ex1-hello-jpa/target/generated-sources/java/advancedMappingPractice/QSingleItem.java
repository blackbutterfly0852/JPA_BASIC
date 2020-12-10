package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSingleItem is a Querydsl query type for SingleItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSingleItem extends EntityPathBase<SingleItem> {

    private static final long serialVersionUID = 2066838594L;

    public static final QSingleItem singleItem = new QSingleItem("singleItem");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public QSingleItem(String variable) {
        super(SingleItem.class, forVariable(variable));
    }

    public QSingleItem(Path<? extends SingleItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSingleItem(PathMetadata metadata) {
        super(SingleItem.class, metadata);
    }

}

