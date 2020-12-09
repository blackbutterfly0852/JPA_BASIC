package advancedMappingPractice;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class ClassBook extends ClassItem{

    private String author;
    private String isbn;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}
