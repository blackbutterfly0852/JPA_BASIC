package persistencePractice;

import javax.persistence.*;

// 201009 엔티티 맵핑
@Entity // JPA가 내부적으로 구분하는 이름, 기본값을 사용해야한다.
@Table(name = "USER") // DB TABLE 명(USER) 이랑 맵핑
public class persistenceMember {

    @Id
    private Long id;
    @Column(name = "userName")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
