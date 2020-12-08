package relationalMappingPractice;

import javax.persistence.*;

// 201208 연관관계 매핑 기초
@Entity
public class SingleMember {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USERNAME")
    private String name;
    private int age;

    // 1. 데이터 중심의 객체 설계
    // @Column(name="TEAM_ID")
    // private Long teamId;

    // 2. 객체 지향 설계
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private SingleTeam team;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public SingleTeam getTeam() {
        return team;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(SingleTeam team) {
        this.team = team;
    }
}
