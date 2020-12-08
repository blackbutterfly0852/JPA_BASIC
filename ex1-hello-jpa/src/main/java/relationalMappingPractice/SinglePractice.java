package relationalMappingPractice;

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

        try{
            SingleTeam team = new SingleTeam();
            team.setName("A팀");
            em.persist(team);

            SingleMember memberA = new SingleMember();
            memberA.setName("김동우");
            memberA.setAge(30);
            memberA.setTeam(team); // 단방향 연관관계 설정, 참조 저장

            em.persist(memberA);
            tx.commit();

            // 참조로 연관관계 조회 - 객체 그래프 탐색
            SingleMember findMember = em.find(SingleMember.class, memberA.getId());
            SingleTeam findTeam = findMember.getTeam();
            System.out.println("findTeam.getId() = "  + findTeam.getId());

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
