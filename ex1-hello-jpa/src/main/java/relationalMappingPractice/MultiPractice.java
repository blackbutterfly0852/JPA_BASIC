package relationalMappingPractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MultiPractice {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            MultiTeam team = new MultiTeam();
            team.setName("A팀");
            em.persist(team);

            MultiMember memberA = new MultiMember();
            memberA.setName("김동우");
            memberA.setAge(30);
            memberA.setTeam(team); // 단방향 연관관계 설정, 참조 저장
            team.addMembers(memberA); // 양방향 연관관계 설정, 참조 저장

            em.persist(memberA);
            tx.commit();

            // 참조로 양방향 연관관계 조회 - 객체 그래프 탐색
            // 1) Member -> Team
            MultiMember findMember = em.find(MultiMember.class, memberA.getId());
            MultiTeam findTeam = findMember.getTeam();

            // 2) Team -> Member
            MultiTeam multiTeam = em.find(MultiTeam.class, team.getId());
            for(MultiMember m : multiTeam.getMembers()){
                System.out.println("name = " + m.getName() + " age = " + m.getAge() + " team = " + m.getTeam().getName());
            }

        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
