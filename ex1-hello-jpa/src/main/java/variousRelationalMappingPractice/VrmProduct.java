package variousRelationalMappingPractice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VrmProduct {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // 4. 다대다 양방향 매핑 추가
    @ManyToMany(mappedBy = "vrmProductList")
    private List<VrmMember> vrmMemberList = new ArrayList<>();
}
