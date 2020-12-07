package hellojpa;

import javax.persistence.*;


public class JpaMain_Practice {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();



        try{
            Member member = new Member();
            member.setId(100L);
            member.setName("김동우");
            em.persist(member);
            tx.commit();
            //em.clear();

            System.out.println("============================");
            Member findMember = em.find(Member.class,100L);
            findMember.setName("김정우");
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();

        }
        emf.close();

    }

}
