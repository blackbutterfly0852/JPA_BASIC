package variousRelationalMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVrmProduct is a Querydsl query type for VrmProduct
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVrmProduct extends EntityPathBase<VrmProduct> {

    private static final long serialVersionUID = 390658709L;

    public static final QVrmProduct vrmProduct = new QVrmProduct("vrmProduct");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<VrmMember, QVrmMember> vrmMemberList = this.<VrmMember, QVrmMember>createList("vrmMemberList", VrmMember.class, QVrmMember.class, PathInits.DIRECT2);

    public QVrmProduct(String variable) {
        super(VrmProduct.class, forVariable(variable));
    }

    public QVrmProduct(Path<? extends VrmProduct> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVrmProduct(PathMetadata metadata) {
        super(VrmProduct.class, metadata);
    }

}

