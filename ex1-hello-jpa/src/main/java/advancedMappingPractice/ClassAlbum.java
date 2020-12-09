package advancedMappingPractice;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class ClassAlbum extends ClassItem {

    private  String artist;
    public void setArtist(String artist) {
        this.artist = artist;
    }
}
