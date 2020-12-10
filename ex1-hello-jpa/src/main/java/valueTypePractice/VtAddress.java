package valueTypePractice;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class VtAddress {

   private String city;
   private String street;
   private String zipcode;

    public VtAddress() {

    }

    public VtAddress(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VtAddress)) return false;
        VtAddress vtAddress = (VtAddress) o;
        return Objects.equals(city, vtAddress.city) &&
                Objects.equals(street, vtAddress.street) &&
                Objects.equals(zipcode, vtAddress.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }

    // Getter, Setter...

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
