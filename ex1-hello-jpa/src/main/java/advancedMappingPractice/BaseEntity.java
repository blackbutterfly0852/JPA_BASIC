package advancedMappingPractice;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
    @Column(name="INSERT_MEMBER")
    private String createdBy;
    private LocalDate createdDate;
    @Column(name="UPDATE_MEMBER")
    private String modifiedBy;
    private LocalDateTime lastModifiedDate;

    // Getter, Setter
}
