package variousRelationalMappingPractice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VrmLocker {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // 3. 일대일 주테이블 양방향
    @OneToOne(mappedBy = "locker")
    private VrmMember member;
}
