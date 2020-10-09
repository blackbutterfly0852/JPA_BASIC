package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
// 201008 JPA 소개
public class JpaMain {

    public static void main(String[] args) {
        // 1. EntityManagerFactory 생성 : persistenceUnitName은 persistence.xml에서 확인.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 2. EntityManager 및 트랜잭션 생성
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 3. Member 객체 생성
            // Member createMember = new Member();
            // createMember.setId(1L);
            // createMember.setName("helloA");

            // 3. Member 객체 저장 및 트랜잭션 커밋
            // em.persist(createMember);
            // tx.commit();

            // 3-2. Member 객체 수정
            // Member updateMember = em.find(Member.class,1L);
            // updateMember.setName("helloB");
            // tx.commit();
            // em.persis(updateMember) 작성 X
            // JPA를 통해서 엔티티를 가져오면, JPA가 관리
            // 커밋 시점에 변경되었는지 체크 -> 변경되었으면 자동 UPDATE

            // 3-3. Member 객체 삭제
            // em.remove(updateMember);

            // 3-4. JPQL : 테이블이 아닌, 객체를 대상으로 조회
            // 이점 : 페이징
            List<Member> members = em.createQuery("select m from Member m", Member.class)
                    //.setFirstResult(1)
                    //.setMaxResults(8)
                    .getResultList();

             for(Member member : members){
                 System.out.println(member.getId() + " " + member.getName());
             }

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
