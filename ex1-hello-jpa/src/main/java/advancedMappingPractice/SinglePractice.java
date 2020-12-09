package advancedMappingPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SinglePractice {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            SingleBook book = new SingleBook();
            book.setAuthor("김동우");
            book.setIsbn("123123");
            book.setName("자서전");
            book.setPrice(10000);
            // ITEM 테이블에 저장
            em.persist(book);
            tx.commit();
            em.clear();
            // ITEM 테이블에서 조회
            SingleBook findBook = em.find(SingleBook.class, book.getId());

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
