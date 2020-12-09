package persistencePractice;

import javax.persistence.*;

@Entity
// 201010 기본 키 맵핑
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, allocationSize = 1) // allocationSize(시퀀스 증가값) 반드시 1로 설정해야 한다

@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 1) // allocationSize(시퀀스 증가값) 반드시 1로 설정해야 한다

public class Member_3 {
    // @Id : 직접할당
    // @GeneratedValue : 자동 생성 // Oracle_Sequence

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR")
    @GeneratedValue(strategy = GenerationType.TABLE,  generator = "MEMBER_SEQ_GENERATOR") // 잘 사용 X
    private Long id; // Integer 10억 이상 X -> Long, 애플리케이션 중간에 Integer에서 Long으로 변경하는 것이 더 어렵다.

    @Column(name ="name", nullable = false)
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
