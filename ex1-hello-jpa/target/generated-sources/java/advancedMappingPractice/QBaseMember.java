package advancedMappingPractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseMember is a Querydsl query type for BaseMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBaseMember extends EntityPathBase<BaseMember> {

    private static final long serialVersionUID = 149995922L;

    public static final QBaseMember baseMember = new QBaseMember("baseMember");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    //inherited
    public final DatePath<java.time.LocalDate> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath name = createString("name");

    public QBaseMember(String variable) {
        super(BaseMember.class, forVariable(variable));
    }

    public QBaseMember(Path<? extends BaseMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseMember(PathMetadata metadata) {
        super(BaseMember.class, metadata);
    }

}

