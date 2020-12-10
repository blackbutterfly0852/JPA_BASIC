package valueTypePractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVtAddress is a Querydsl query type for VtAddress
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QVtAddress extends BeanPath<VtAddress> {

    private static final long serialVersionUID = 1126133230L;

    public static final QVtAddress vtAddress = new QVtAddress("vtAddress");

    public final StringPath city = createString("city");

    public final StringPath street = createString("street");

    public final StringPath zipcode = createString("zipcode");

    public QVtAddress(String variable) {
        super(VtAddress.class, forVariable(variable));
    }

    public QVtAddress(Path<? extends VtAddress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVtAddress(PathMetadata metadata) {
        super(VtAddress.class, metadata);
    }

}

