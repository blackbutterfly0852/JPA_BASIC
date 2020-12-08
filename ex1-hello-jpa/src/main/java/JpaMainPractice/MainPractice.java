package JpaMainPractice;



import hellojpa.Member;

import javax.persistence.*;
import javax.persistence.EntityTransaction;


public class MainPractice {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try{
//            // 1. 비영속 상태(new)
//            Member createMember = new Member();
//            createMember.setId(1L);
//            createMember.setName("hello1");
//
//            // 2. 영속 상태(managed)
//            em.persist(createMember);
//            //tx.commit();
//
//            // 3. 준영속 상태(detached)
//            Member findMember1 = em.find(Member.class, 1L);
//            System.out.println("============================");
//            //em.close(); // 오류
//            //em.clear();
//            em.detach(createMember);
//            Member findMember2 = em.find(Member.class, 1L);
//
//            // 4. 삭제(remove)
//            //em.remove(createMember);

            Member memberA = new Member();
            memberA.setId(3L);
            memberA.setName("hello3");
            em.persist(memberA);
            em.flush(); // insert 쿼리 강제로 발생
            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

}
