package proxyPractice;

import javax.persistence.*;

@Entity
public class ProxyMember {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private ProxyTeam team;

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProxyTeam getTeam() {
        return team;
    }


}


