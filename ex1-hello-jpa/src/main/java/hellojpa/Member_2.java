package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
// 201010 필드와 컬럼 맵핑
@Entity
public class Member_2 {

    @Id
    private Long id;
    // 객체는 username으로 사용하고, 컬럼은 name으로 사용한다.
    @Column(name = "name" , insertable = true, updatable = false, nullable = false) // update X , not null
    private String username;
    private Integer age;
    // DB에는 Enumerated 타입 X
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    // 날짜/시간 과거
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 날짜/시간 최신
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    // Varchar를 넘어서는 큰 컨텐츠 : CLOB, BLOB
    @Lob
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
