package proxyPractice;

import mappingPractice.SequenceMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProxyPractice {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
//            ProxyMember memberA = new ProxyMember();
//            memberA.setName("김동우");
//            em.persist(memberA);
//            em.flush();
//            em.clear();
//
//            ProxyMember findRealMember = em.find(ProxyMember.class, memberA.getId()); // 바로 쿼리 발생
//            em.clear();
//
//            // 아래 그림 참조
//            ProxyMember findRefMember = em.getReference(ProxyMember.class, memberA.getId()); // 쿼리 발생 X
//            System.out.println("=========================");
//            findRefMember.getName(); // 이때 쿼리 발생
//            em.clear();
//
//            // 초기화 시 프록시가 엔티티로 변하는 것이 아니라 프록시 객체 내부 target값에 실제 엔티티 참조값이 저장되는 것이다.
//            ProxyMember findRefMember2 = em.getReference(ProxyMember.class, memberA.getId()); // 쿼리 발생 X
//            System.out.println("before = " + findRefMember2.getClass());
//            findRefMember2.getName();
//            System.out.println("after = " + findRefMember2.getClass());

            // 타입비교는 instanceOf 활용한다.
//              ProxyMember memberA = new ProxyMember();
//              memberA.setName("김동우");
//              em.persist(memberA);
//
//              ProxyMember memberB = new ProxyMember();
//              memberB.setName("김정우");
//              em.persist(memberB);
//
//              em.flush();
//              em.clear();

//              ProxyMember findRealMemberA = em.find(ProxyMember.class, memberA.getId());
//              ProxyMember findRefMemberB = em.getReference(ProxyMember.class, memberB.getId());
//              System.out.println("A == B? : " + (findRealMemberA.getClass() == findRefMemberB.getClass())); // false
//              System.out.println("A instanceof ProxyMember? : " + (findRealMemberA instanceof ProxyMember)); // true
//              System.out.println("A instanceof ProxyMember? : " + (findRefMemberB instanceof ProxyMember)); // true

            // 영속성 컨테스트에 찾는 엔티티가 이미 있으면 em.getReference();를 해도 실제 엔티티를 반환한다.
            // JPA에서는 같은 영속성 컨테스트 내에서는 동일한 엔티티, 동일한 PK 이면 실제 객체이든 프록시 객체이든 == 비교가 true여야 한다.
//            ProxyMember memberA = new ProxyMember();
//            memberA.setName("김동우");
//            em.persist(memberA);
//            em.flush();
//            em.clear();
//            ProxyMember findRealMemberA = em.find(ProxyMember.class, memberA.getId());
//            System.out.println("findRealMemberA = " + findRealMemberA.getClass()); // 실제 객체 반환
//            ProxyMember findRefMemberA = em.getReference(ProxyMember.class, memberA.getId());
//            System.out.println("findRefMemberA = " + findRefMemberA.getClass()); // 실제 객체 반환
//
//
//            // 그럼  프록시 객체를 조회하고 실제 객체를 조회한다면?
//            ProxyMember memberB = new ProxyMember();
//            memberB.setName("김동우");
//            em.persist(memberB);
//            em.flush();
//            em.clear();
//            ProxyMember findRefMemberB = em.getReference(ProxyMember.class, memberB.getId());
//            System.out.println("findRefMemberB = " + findRefMemberB.getClass()); // 프록시 객체 반환
//            ProxyMember findRealMemberB = em.find(ProxyMember.class, memberB.getId());
//            System.out.println("findRealMemberB = " + findRealMemberB.getClass()); // 프록시 객체 반환
//
//            System.out.println("findRefMemberB == findRealMemberB: " + (findRefMemberB == findRealMemberB)); // 원칙상 여기가 TRUE여야 하기때문에 em.find()도 프록시 객체 반환.

            // org.hibernate.LazyInitializationException
            ProxyMember memberA = new ProxyMember();
            memberA.setName("김동우");
            em.persist(memberA);
            em.flush();
            em.clear();
            ProxyMember findRefMemberA = em.getReference(ProxyMember.class, memberA.getId());
            // em.detach(findRefMemberA);
            em.clear();
            // em.close();
            findRefMemberA.getName(); // org.hibernate.LazyInitializationException: could not initialize proxy


        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        } finally {
            em.close();
        }
        emf.close();
    }

}
