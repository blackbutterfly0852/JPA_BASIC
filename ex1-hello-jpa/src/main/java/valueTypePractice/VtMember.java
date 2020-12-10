package valueTypePractice;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class VtMember {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    @Embedded
    private VtPeriod workPeriod;

    @Embedded
    private VtAddress homeAddress;

    @Embedded
    @AttributeOverrides(
            {@AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
                    @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
                    @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
            })
    private VtAddress workAddress;


    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<VtAddress> addressHistory = new ArrayList<>();
//
//    // 연관관계 편의 메소드
//    public void addAddress(VtAddress vtAddress) {
//        this.addressHistory.add(vtAddress);
//    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<VtAddressHistory> addressHistory = new ArrayList<>();

    // 연관관계 편의 메소드
    public void addAddressHistory(VtAddressHistory vtAddressHistory) {
        this.addressHistory.add(vtAddressHistory);
    }

    // Getter, Setter...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VtPeriod getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(VtPeriod workPeriod) {
        this.workPeriod = workPeriod;
    }

    public VtAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(VtAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public VtAddress getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(VtAddress workAddress) {
        this.workAddress = workAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<VtAddressHistory> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<VtAddressHistory> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
