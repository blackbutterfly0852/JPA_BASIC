package valueTypePractice;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class VtPractice {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 1. 값타입 예제
//            VtMember member = new VtMember();
//            member.setName("김동우");
//            member.setHomeAddress(new VtAddress("서울", "노원구","139-221"));
//            member.setWorkPeriod(new VtPeriod());
//            em.persist(member);
//            tx.commit();

            // 2. 값 타입은 공유하면 안된다 -> SIDE EFFECT 발생
//              VtAddress vtAddress = new VtAddress("서울", "노원구","139-221");
//              VtMember memberA = new VtMember();
//              memberA.setName("김동우");
//              memberA.setHomeAddress(vtAddress);
//              memberA.setWorkPeriod(new VtPeriod());
//              em.persist(memberA);
//
//              VtAddress copyAddress = new VtAddress(vtAddress.getCity(),vtAddress.getStreet(),vtAddress.getZipcode());
//              VtMember memberB = new VtMember();
//              memberB.setName("김정우");
//              memberB.setHomeAddress(copyAddress);
//              memberB.setWorkPeriod(new VtPeriod());
//              em.persist(memberB);
//
//              // 의도와 달리 Update 쿼리 2번 발생 -> 같이 쓰고 싶으면 값 타입이 아니라 엔티티로 만들거나 복사해서 사용해야 한다.
//              memberA.getHomeAddress().setCity("강원도");
//              tx.commit();

            // 3. 컬렉션 값 타입
            VtMember memberA = new VtMember();
            memberA.setName("김동우");
            VtAddress vtAddress = new VtAddress("서울", "노원구", "139-221");
            memberA.setHomeAddress(vtAddress);
            memberA.getFavoriteFoods().add("치킨");
            memberA.getFavoriteFoods().add("피자");
            memberA.getFavoriteFoods().add("족발");

            //memberA.getAddressHistory().add(new VtAddress("강원도", "노원구", "139-221"));
            // memberA.getAddressHistory().add(new VtAddress("경기도", "노원구", "139-221"));

            memberA.addAddressHistory(new VtAddressHistory("강원도", "노원구", "139-221"));
            memberA.addAddressHistory(new VtAddressHistory("경기도", "노원구", "139-221"));
            memberA.setWorkPeriod(new VtPeriod());
            em.persist(memberA);
            em.flush();
            em.clear();

            System.out.println("=============start============");
            VtMember findMember = em.find(VtMember.class, memberA.getId()); // Member 테이블만 조회

//          List<VtAddress> addressHistory = findMember.getAddressHistory(); // 컬렉션은 지연로딩
//          for(VtAddress address : addressHistory){
//              System.out.println("addressHistory = " + address.getCity());
//          }

            List<VtAddressHistory> addressHistory = findMember.getAddressHistory();

            for (VtAddressHistory address : addressHistory) {
                System.out.println("addressHistory = " + address.getAddress().getCity());
            }


            Set<String> favoriteFoods = findMember.getFavoriteFoods(); // 컬렉션은 지연로딩
            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }

            // 값 타입은 통으로 교체해야 한다.
            // 값 타입 컬렉션 수정
            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");


            // 결과적으로는 의도한대로 되었지만, 과정은 의도한대로 되지 않았다.
            // ADDRESS 테이블의 해당 Member 관련된 주소를 다 지우고, 이전 살아남은 거와 새로 추가한 것을 한번에 넣어준다.
            // 이렇게 복잡하게 할 바에야 새로운 엔티티로 만든다. AddressHistory
//            findMember.getAddressHistory().remove(new VtAddress("강원도", "노원구", "139-221"));
//            findMember.getAddressHistory().add(new VtAddress("부산광역시", "노원구", "139-221"));


              List<VtAddressHistory> findVtAddressHistory = em.createQuery("select ah from VtAddressHistory ah where ah.vtMember =:vtMember and ah.address =:address",VtAddressHistory.class )
                    .setParameter("vtMember", findMember)
                    .setParameter("address", new VtAddress("강원도", "노원구", "139-221")).getResultList();
              findVtAddressHistory.get(0).setAddress(new VtAddress("부산광역시","노원구","139-221"));
              tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
        emf.close();
    }
}
