package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJoinItem is a Querydsl query type for JoinItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJoinItem extends EntityPathBase<JoinItem> {

    private static final long serialVersionUID = 234885604L;

    public static final QJoinItem joinItem = new QJoinItem("joinItem");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public QJoinItem(String variable) {
        super(JoinItem.class, forVariable(variable));
    }

    public QJoinItem(Path<? extends JoinItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJoinItem(PathMetadata metadata) {
        super(JoinItem.class, metadata);
    }

}

