package valueTypePractice;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class VtPeriod {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public VtPeriod(){

    }

    // Getter, Setter...
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
