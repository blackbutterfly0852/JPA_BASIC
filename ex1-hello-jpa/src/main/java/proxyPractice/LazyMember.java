package proxyPractice;

import javax.persistence.*;

@Entity
public class LazyMember {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private LazyTeam team;

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(LazyTeam team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LazyTeam getTeam() {
        return team;
    }


}


