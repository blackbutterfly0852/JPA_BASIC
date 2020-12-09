package advancedMappingPractice;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class JoinAlbum extends  JoinItem {

    private  String artist;
    public void setArtist(String artist) {
        this.artist = artist;
    }
}
