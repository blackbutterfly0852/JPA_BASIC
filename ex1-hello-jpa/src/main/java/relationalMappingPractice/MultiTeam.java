package relationalMappingPractice;

import javax.persistence.*;
import java.util.*;

@Entity
public class MultiTeam {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "team")
    List<MultiMember> members = new ArrayList<MultiMember>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMembers(MultiMember member) {
        this.members.add(member);
    }

    public List<MultiMember> getMembers() {
        return members;
    }
}
