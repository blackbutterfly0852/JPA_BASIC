package advancedMappingPractice;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class ClassMovie extends ClassItem{

    private String director;
    private String actor;

    public void setDirector(String director) {
        this.director = director;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
