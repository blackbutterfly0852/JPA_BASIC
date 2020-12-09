package variousRelationalMappingPractice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 4. 다양한 연관관계 매핑
@Entity
public class VrmMember {
    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;

    // 1. 다대일
    //@ManyToOne
    //@JoinColumn(name="TEAM_ID")
    //private VrmTeam team;

    // 2. 일대다 양방향 추가
    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
    private VrmTeam team;


    // 3. 일대일 주테이블 단방향
    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private VrmLocker locker;

    // 4. 다대다
    @ManyToMany
    @JoinTable(name = "MEMBER_PRODUCT")
    private List<VrmProduct> vrmProductList = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
}
