package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

// 201010 기본 키 맵핑
public class JpaMain_3 {

    public static void main(String[] args) {
        // 1. EntityManagerFactory 생성 : persistenceUnitName은 persistence.xml에서 확인.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 2. EntityManager 및 트랜잭션 생성
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member_3 member = new Member_3();
            member.setUserName("김동우");
            em.persist(member);

            Member_3 member2 = new Member_3();
            member2.setUserName("김동우_2");
            em.persist(member2);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }

}
