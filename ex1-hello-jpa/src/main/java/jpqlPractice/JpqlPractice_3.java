package jpqlPractice;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpqlPractice_3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try{

            // 11. 조건식
            Member memberA = new Member();
            memberA.setAge(10);
            em.persist(memberA);
            em.flush();

            // 1) 단순 CASE 식
            String sql17 = "select case when m.age <=10 then '학생요금' " +
                                      " when m.age >=60 then '경로요금' " +
                                      " else '일반요금' " +
                                 " end from Member m";

            List<String> query23List = em.createQuery(sql17, String.class).getResultList();
            System.out.println("CASE = " + query23List.get(0));

            // 2) COALESCE 식 : 하나씩 조회해서 null이 아니면 반환
            String sql18 = "select COALESCE(m.name,'이름 없는 회원') from Member m";
            List<Object[]> query25List = em.createQuery(sql18).getResultList();
            System.out.println("COALESCE = " + query25List.get(0));

            // 3) NULLIF 식 : 두 값이 같으면 null 반환, 다르면 첫번째 값 반환
            String sql19 = "select COALESCE(m.name,'') from Member m";
            List<Object[]> query26List = em.createQuery(sql19).getResultList();
            System.out.println("NULLIF = " + query26List.get(0));


        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
