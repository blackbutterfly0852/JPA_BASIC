package variousRelationalMappingPractice;

import relationalMappingPractice.MultiMember;
import relationalMappingPractice.MultiTeam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VrmPractice {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            VrmMember memberA = new VrmMember();
            memberA.setName("김동우");
            em.persist(memberA);

            VrmTeam team = new VrmTeam();
            team.setName("A팀");
            // 일쪽에 연관관계 주인을 설정
            // 그러나 FK가 MEMBER 테이블에 존재
            // 결과적으로 UPDATE 문 추가 발생
            team.getMemberList().add(memberA);
            em.persist(team);
            tx.commit();

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
