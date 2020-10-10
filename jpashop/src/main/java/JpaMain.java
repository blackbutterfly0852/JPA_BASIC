
import jpabook.jpashop.domain.Member;

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
            Member createMember = new Member();
            // createMember.setId(1L);
            createMember.setName("helloA");

            // 3. Member 객체 저장 및 트랜잭션 커밋
            em.persist(createMember);
            tx.commit();


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
