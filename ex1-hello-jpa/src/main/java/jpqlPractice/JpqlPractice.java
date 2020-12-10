package jpqlPractice;



import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.*;
import java.util.List;

public class JpqlPractice {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try{
            // 1. JPQL
            for(int i = 1 ; i < 101 ; i++){
                Member memberA = new Member();
                memberA.setName("김동우" + i);
                memberA.setAge(i);
                em.persist(memberA);
            }

            em.flush();
            em.clear();

            String sql1 = "select m from Member m where m.age > 18";
            List<Member> query1List = em.createQuery(sql1, Member.class).getResultList();
            System.out.println("query1List.size() = " + query1List.size());


            // 2. QueryDSL
            em.clear();
            JPAQueryFactory query =new JPAQueryFactory(em);
            QMember m = QMember.member;
            List<Member> query2List = query.selectFrom(m)
                    .where(m.age.gt(18))
                    .orderBy(m.name.desc())
                    .fetch();
            System.out.println("query2List.size() = " + query2List.size());


            // 3. Native SQL
            String sql2 = "SELECT MEMBER_ID, AGE, TEAM_ID, NAME FROM MEMBER WHERE NAME = '김동우1'";
            List<Member> query3List =  em.createNativeQuery(sql2, Member.class).getResultList();
            System.out.println("query3List.size() = " + query3List.size());

            // 4. 집합과 정렬
            String sql3 = "select COUNT(m), SUM(m.age), AVG(m.age), MAX(m.age), MIN(m.age) from Member m";
            Query query4List = em.createQuery(sql3);
            Object o = query4List.getSingleResult();
            Object[] result = (Object[]) o;
            for(Object r : result){
                System.out.println("집합과 정렬 = " + r);
            }

            // 5. TypeQuery, Query
            // 반환 타입이 명확할 때
            TypedQuery<Member> query5List = em.createQuery("SELECT m FROM Member m", Member.class);
            // 반환 타입이 불명확할 때
            Query query6List = em.createQuery("SELECT m.name, m.age from Member m");

            // 6. 파라미터 바인딩 - 이름 기준, 위치 기준 -> 이름 기준으로 사용할 것
            String sql4 = "select m from Member m where m.name =:name";
            List<Member> query7List = em.createQuery(sql4,Member.class).setParameter("name", "김동우1").getResultList();
            System.out.println("member.size() : " + query7List.size());

            // 7. 프로젝션
            // 1) Query 타입으로 조회
            List query8List = em.createQuery("select m.name, m.age from Member m").getResultList();
            Object o1 = query8List.get(0);
            Object[] resultO1 = (Object[]) o1;
            System.out.println("name = " + resultO1[0]);
            System.out.println("name = " + resultO1[1]);

            // 2) Object[] 타입으로 조회
            List<Object[]> query9List = em.createQuery("select m.name, m.age from Member m").getResultList();
            Object[] resultO2 = query9List.get(0);
            System.out.println("name = " + resultO2[0]);
            System.out.println("name = " + resultO2[1]);

            // 3) new 명령어로 조회 - 단순 값을 DTO로 바로 조회
            // 패키지 명을 포함한 전체 클래스 명 입력
            // 순서와 타입이 일치하는 생성자 필요
            List<MemberDTO> query10List = em.createQuery("select new jpqlPractice.MemberDTO(m.name, m.age) from Member m", MemberDTO.class).getResultList();
            MemberDTO resultO3 = query10List.get(0);
            System.out.println("name = " + resultO3.getName());
            System.out.println("name = " + resultO3.getAge());

            // 8. 페이징 API
            String sql5 = "select m from Member m order by m.name desc";
            List<Member> query11List = em.createQuery(sql5, Member.class)
                        .setFirstResult(10)
                        .setMaxResults(20)
                        .getResultList();

            for(Member member : query11List){
                System.out.println("member.name = " + member.getName() + " member.age : " + member.getAge());
            }



        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
