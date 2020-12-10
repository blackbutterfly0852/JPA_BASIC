package persistencePractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// 201009 영속성 관리 - 내부 동작 방식
public class JpaMain_2 {

    public static void main(String[] args) {
        // 1. EntityManagerFactory 생성 : persistenceUnitName은 persistence.xml에서 확인.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 2. EntityManager 및 트랜잭션 생성
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
             //3. Member 객체 생성 -> (1) 비영속상태
             persistenceMember createMember = new persistenceMember();
             createMember.setId(1L);
             createMember.setName("helloA");

             //3. Member 객체 저장 및 트랜잭션 커밋
             em.persist(createMember); // (2) 영속상태
             // em.detach(createMember);  // (3) 준영속 상태

             // 3-1. 엔티티 조회, 1차 캐시 -> 현재 1차 캐쉬에 있으므로, select 쿼리 발생 X
             persistenceMember memberA = em.find(persistenceMember.class,1L);
             // 만약, memberA가 1차 캐시에 없어, DB에서 조회하면 영속성 컨테스트에 저장
             // memberB는 memberA와 key가 동일하기 때문에 1차 캐쉬에서 조회 -> 결과적으로 memberA의 쿼리만 발생
             // 3-2. 영속 엔티티의 동일성 보장 (memberA == memberB)
             // Member memberB = em.find(Member.class,1L);

             // 3-3. 엔티티 등록 : 트랜잭션을 지원하는 쓰기 지원
             tx.commit(); // 이때 insert 쿼리 발생

             // 3-4. 엔티티 수정 - 변경감지
             memberA.setName("helloA_Mo");
             tx.commit(); // 이때 update 쿼리 발생

             // 4. Member 객체 삭제 -> (4) 삭제
             // em.remove(updateMember);


            // 5. flush()
            persistenceMember memberC = new persistenceMember();
            memberC.setId(2L);
            memberC.setName("HelloC");
            em.persist(memberC); // 영속성 컨테스트(1차캐쉬) 저장 및 쓰기 지연 SQL에 저장
            em.flush(); // flush() 직접 호출, 쓰기 지연 SQL에 있는 쿼리 발생
            tx.commit(); // DB 커밋.

            persistenceMember memberCM = em.find(persistenceMember.class, 2L);
            memberCM.setName("HelloCM");
            tx.commit(); // flush() -> 엔티티와 스냅샷 비교 -> 쓰기 지연 SQL에 업데이트 쿼리 저장 -> flush() -> 쿼리 발생 -> DB commit;

            // 6. 준영속상태
            // em.detach(member) // 영속상태 -> 준영속상태, 영속성 컨텍스트에서 관리 X
            // em.clear() // 영속성 컨텍스트를 완전히 초기화. TEST 시
            // em.close() // 영속성 컨텍스트를 종료.


        } catch(Exception e){
            tx.rollback();
        } finally {
            // 5. EntityManager 종료
            em.close();;
        }

        // 6. EntityManagerFactory 종료
        emf.close();



    }
}
