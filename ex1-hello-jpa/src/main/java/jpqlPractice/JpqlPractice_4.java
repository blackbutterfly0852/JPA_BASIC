package jpqlPractice;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class JpqlPractice_4 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try{

            // 1. 경로 표현식
            Team teamA = new Team();
            em.persist(teamA);

            Member memberA = new Member();
            memberA.setAge(10);
            memberA.setTeam(teamA);
            em.persist(memberA);

            Order orderA = new Order();
            orderA.setMember(memberA);
            Order orderB = new Order();
            orderB.setMember(memberA);
            em.persist(orderA);
            em.persist(orderB);

            // 1) 상태필드 경로 탐색 : m.name
            String sql1 = "select m.name from Member m inner join m.team inner join m.orders o";
            List<String> result1List = em.createQuery(sql1,String.class).getResultList();
            System.out.println("result1List.size() = " + result1List.size());

            // 2) 단일 값 연관 경로 탐색 : m.name
            String sql2 = "select o.member from Order o where o.member =:member";
            Member result2List = em.createQuery(sql2,Member.class).setParameter("member",memberA).getSingleResult();
            System.out.println("result2List = " + result2List.toString());

            // 3) 컬렉션 값  연관 경로 탐색 : m.orders -> 이후 경로 탐색 불가 및 묵시적 조인 발생
            String sql3 = "select m.orders from Member m";
            Collection result3List = em.createQuery(sql3, Collection.class).getResultList();
            System.out.println("result3List.size() = " + result3List.size());








        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
