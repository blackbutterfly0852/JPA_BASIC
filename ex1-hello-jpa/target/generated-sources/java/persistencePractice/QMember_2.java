package persistencePractice;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember_2 is a Querydsl query type for Member_2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMember_2 extends EntityPathBase<Member_2> {

    private static final long serialVersionUID = 667618913L;

    public static final QMember_2 member_2 = new QMember_2("member_2");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> lastModifiedDate = createDateTime("lastModifiedDate", java.util.Date.class);

    public final EnumPath<RoleType> roleType = createEnum("roleType", RoleType.class);

    public final DatePath<java.time.LocalDate> testLocalDate = createDate("testLocalDate", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> testLocalDateTime = createDateTime("testLocalDateTime", java.time.LocalDateTime.class);

    public final StringPath username = createString("username");

    public QMember_2(String variable) {
        super(Member_2.class, forVariable(variable));
    }

    public QMember_2(Path<? extends Member_2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember_2(PathMetadata metadata) {
        super(Member_2.class, metadata);
    }

}

