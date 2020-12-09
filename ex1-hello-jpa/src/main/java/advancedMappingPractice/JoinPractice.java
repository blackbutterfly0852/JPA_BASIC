package advancedMappingPractice;

import mappingPractice.SequenceMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JoinPractice {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            JoinBook book = new JoinBook();
            book.setAuthor("김동우");
            book.setIsbn("123123");
            book.setName("자서전");
            book.setPrice(10000);
            // JoinBook , JoinItem 각각 테이블에 저장
            em.persist(book);
            tx.commit();
            em.clear();
            // JoinBook 기준으로 JoinItem inner join
            JoinBook findBook = em.find(JoinBook.class, book.getId());

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
