package jpqlPractice;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpqlPractice_6 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try{

            Member memberA = new Member();
            memberA.setName("회원1");
            memberA.setAge(0);
            em.persist(memberA);

            Member memberB = new Member();
            memberB.setName("회원2");
            memberB.setAge(0);
            em.persist(memberB);

            // 벌크연산 수행
            // FLUSH 자동 호출 : 커밋, 쿼리 발생, flush()
            // FLUSH 후 UPDATE 쿼리 발생
            String sql11 = "update Member m set m.age = 20";
            int resultCount = em.createQuery(sql11).executeUpdate();
            System.out.println("resultCount = " + resultCount);

            // 벌크 연산은 영속성 컨테스트를 무시하고 데이터베이스에 직접 쿼리
            // 그래서 DB에는 모든 Member의 나이가 20이나
            // 영속성 컨테스트는 현재 0이므로 아래 findMemberA의 나이는 0으로 출력
            // 이를 방지하기 위해 벌크연산 후 em.clear() 꼭 해줄 것.
            em.clear();
            Member findMemberA = em.find(Member.class, memberA.getId());
            System.out.println("memberA.age = " + findMemberA.getAge());

            tx.commit();


        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
