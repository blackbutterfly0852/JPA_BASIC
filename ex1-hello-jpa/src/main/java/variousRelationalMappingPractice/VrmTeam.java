package variousRelationalMappingPractice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
public class VrmTeam {

    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;

    // 1. 다대일
    //@OneToMany(mappedBy = "team")
    //private List<VrmMember> memberList = new ArrayList<>();

    // 2. 일대다
    @OneToMany
    @JoinColumn(name="TEAM_ID")
    private List<VrmMember> memberList = new ArrayList<>();


    public void setName(String name) {
        this.name = name;
    }

    public List<VrmMember> getMemberList() {
        return memberList;
    }
}
