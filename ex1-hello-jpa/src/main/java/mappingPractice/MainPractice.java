package mappingPractice;

import javax.persistence.*;

public class MainPractice {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 1. Identity 전략
//            IdentityMember member = new IdentityMember();
//            member.setUserName("kim");
//            System.out.println("=======================");
//            em.persist(member); // Identity 전략은 insert 쿼리가 이 시점에 발생.
//            System.out.println("memberId = " + member.getId());
//            System.out.println("=======================");
//            tx.commit();
            // 2. Sequence 전략
            SequenceMember memberA = new SequenceMember();
            memberA.setUserName("kim");
            // Sequence 전략은 persist() 시점에 call next value for MEMBER_SEQ
            // 그럼 미리 지정해 놓은 만큼의 SEQ 숫자를 메모리상에 올려놓는다.
            // 만약 50개를 다 사용했으면 그 다음에 50개를 다시 호출하여 메모리상에 올려 놓는다.
            // 주의점 : 메모리상에 있는 시 SEQ 숫자를 다 사용 못했다면 버려진다.
            em.persist(memberA);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}


