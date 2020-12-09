package advancedMappingPractice;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class SingleAlbum extends SingleItem {

    private  String artist;
    public void setArtist(String artist) {
        this.artist = artist;
    }
}
