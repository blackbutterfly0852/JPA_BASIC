package jpqlPractice;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

public class JpqlPractice_5 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try{

            // 1. 페치조인
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);
            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);
            Team teamC = new Team();
            teamC.setName("팀C");
            em.persist(teamC);

            Member memberA = new Member();
            memberA.setName("회원1");
            memberA.setAge(9);
            teamA.addMemberList(memberA);
            em.persist(memberA);

            Member memberB = new Member();
            memberB.setName("회원2");
            memberB.setAge(12);
            teamA.addMemberList(memberB);
            em.persist(memberB);

            Member memberC = new Member();
            memberC.setName("회원3");
            memberC.setAge(13);
            teamB.addMemberList(memberC);
            em.persist(memberC);

            Member memberD = new Member();
            memberD.setName("회원4");
            memberD.setAge(14);
            em.persist(memberD);

            // 1) 다:1 -> 데이터 뻥튀기 X
            String sql4 = "select m from Member m join fetch m.team";
            List<Member> result4List = em.createQuery(sql4, Member.class).getResultList();
            // 회원1 : 팀A
            // 회원2 : 팀A
            // 회원3 : 팀B
            for(Member m : result4List){
                System.out.println("m.name = " +  m.getName() + " m.team = " + m.getTeam().getName());
            }

            // 2) 1:다 -> 데이터 뻥튀기 O
            // 팀의 결과를 먼저 추출 후 나온 결과를 가지고 Member랑 조인.
            String sql5 = "select t from Team t join fetch t.memberList";
            List<Team> result5List = em.createQuery(sql5, Team.class).getResultList();
            // 팀A : 회원1
            // 팀A : 회원2
            // 팀B : 회원3
            for(Team t : result5List){
                for(Member m : t.getMemberList()){
                    System.out.println("데이터 뻥튀기 : t.name = " +  t.getName() + " m.name = " + m.getName());
                }
            }

            // 3) 데이터 뻥튀기 해결 방법 - distinct
            String sql6 = "select distinct t from Team t join fetch t.memberList";
            List<Team> result6List = em.createQuery(sql6, Team.class).getResultList();
            // 팀A : 회원1
            // 팀A : 회원2
            // 팀B : 회원3
            for(Team t : result6List){
                for(Member m : t.getMemberList()){
                    System.out.println("distinct 사용 : t.name = " +  t.getName() + " m.name = " + m.getName());
                }
            }

            // 4) 페치 조인 대상에는 별칭을 줄 수없다. 하이버네이트는 가능하나 가급적 사용하지 말 것.
            // 데이터 정합성 문제 : 1:다에서 페치조인은 객체 그래프 사상에 따라 다 쪽에 모든 데이터가 조회되도록 설계
            // 그런데, 다 쪽(페치 조인 대상)에 별칭을 주어 where 조건에서 데이터를 필터링을 한다면, 데이터 정합성 문제 발생
            // 아래 m.age > 0  되도록 이면 사용하지 말 것.
            String sql7 = "select distinct t from Team t join fetch t.memberList m where m.age > 10";
            List<Team> result7List = em.createQuery(sql7, Team.class).getResultList();
            System.out.println("result7List.size() = " + result7List.size());
            // 쓰는 경우는 여러개 페치조인을 하는 경우
            // select distinct t from Team t join fetch t.memberList m join fetch m.team

            // 6) 컬렉션 페치조인시 페이징 메모리 문제
            // WARN: HHH000104: firstResult/maxResults specified with collection fetch; applying in memory!
            String sql8 = "select t from Team t join fetch t.memberList m ";
            List<Team> result8List = em.createQuery(sql8, Team.class).setFirstResult(0).setMaxResults(2).getResultList();
            System.out.println("result8List.size() = " + result8List.size());

            // 7) 페이징 문제 해결_1 1:다 -> 다:1
            String sql9 = "select m from Member m join fetch m.team";
            List<Member> result9List = em.createQuery(sql9, Member.class).setFirstResult(0).setMaxResults(2).getResultList();
            System.out.println("result9List.size() = " + result9List.size());

            // 8) Team 먼저 조회 -> Team 개수 만큼 Member 조회 -> 지연로딩이라도 N + 1 문제
            // 해결방법 1 : Team의 meberList 필드의 @BatchSize(size = 100) 추가 (1000 이하의 값)
            // 해결방법 2 : 또는 글로벌 적용 -> persistence.xml에 <property name="hibernate.default_batch_fetch_size" value="100"/>
            // 결국 테이블 수 만큼 쿼리 수 최적화
            em.flush();
            em.clear();
            String sql10 = "select t from Team t";
            List<Team> result10List = em.createQuery(sql10, Team.class).setFirstResult(0).setMaxResults(2).getResultList();
            for(Team t : result10List){
                for(Member m : t.getMemberList()){
                    System.out.println("@BatchSize 사용 : t.name = " +  t.getName() + " m.name = " + m.getName());
                }
            }

            // JPA의 문제는 N+1 -> 페치조인으로 해결
            // 활용편 2 참조
            // 페치 조인을 가져와 그대로 사용한다.
            // 페치 조인을 가져와 애플리케이션에서 DTO로 변환한다.
            // 처음부터 new DTO()를 사용해 가져온다.


        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
