package proxyPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CascadePractice {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Child childA = new Child();
            Child childB = new Child();

            Parent parent = new Parent();
            parent.addChild(childA);
            parent.addChild(childB);

            em.persist(parent);
            em.persist(childA);
            em.persist(childB);
            em.flush();
            em.clear();

            // orphanRemoval = true 시, findParent를 삭제하면 childA, childB도 자동 삭제 -> DELETE 문 3번 발생
            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
        emf.close();
    }
}
