package advancedMappingPractice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BaseMember extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // Getter, Setter...
}
