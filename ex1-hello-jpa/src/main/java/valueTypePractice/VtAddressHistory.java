package valueTypePractice;




import javax.persistence.*;

@Entity
public class VtAddressHistory {

    @Id
    @GeneratedValue
    private Long id;

    private VtAddress address;

    public VtAddressHistory(){

    }

    public VtAddressHistory(String city, String street, String zipcode){
            this.address = new VtAddress(city,street,zipcode);
    }

    public VtAddressHistory(VtAddress address) {
        this.address = address;
    }


    // 2. 일대다 양방향 추가
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", insertable = false, updatable = false)
    private VtMember vtMember;

    // Getter, Setter...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VtAddress getAddress() {
        return address;
    }

    public void setAddress(VtAddress address) {
        this.address = address;
    }
}
