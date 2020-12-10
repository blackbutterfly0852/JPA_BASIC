package valueTypePractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVtPeriod is a Querydsl query type for VtPeriod
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QVtPeriod extends BeanPath<VtPeriod> {

    private static final long serialVersionUID = -1334018937L;

    public static final QVtPeriod vtPeriod = new QVtPeriod("vtPeriod");

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public QVtPeriod(String variable) {
        super(VtPeriod.class, forVariable(variable));
    }

    public QVtPeriod(Path<? extends VtPeriod> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVtPeriod(PathMetadata metadata) {
        super(VtPeriod.class, metadata);
    }

}

