package proxyPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class LazyPractice {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            LazyTeam teamA = new LazyTeam();
            teamA.setName("teamA");
            em.persist(teamA);

            LazyMember memberA = new LazyMember();
            memberA.setName("memberA");
            memberA.setTeam(teamA);
            em.persist(memberA);




//            // LAZY 로딩 경우
//            LazyMember findMemberA = em.find(LazyMember.class, memberA.getId());
//            System.out.println("findMemberA.getTeam() = " + findMemberA.getTeam().getClass()); // 프록시 객체
//            System.out.println("================================================");
//            System.out.println("findMemberA.getTeam().getName() = " + findMemberA.getTeam().getName()); // 이때 쿼리실행


            // JPQL N+1 문제
            LazyTeam teamB = new LazyTeam();
            teamB.setName("teamB");
            em.persist(teamB);

            LazyMember memberB = new LazyMember();
            memberB.setName("memberB");
            memberB.setTeam(teamB);
            em.persist(memberB);

            em.flush();
            em.clear();


            // 1번째 쿼리 후, 쿼리 결과가 N개 라면 N번만큼 쿼리 발생
            List<LazyMember> memberList = em.createQuery(" select m from LazyMember m", LazyMember.class).getResultList();




        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
        emf.close();
    }

}
