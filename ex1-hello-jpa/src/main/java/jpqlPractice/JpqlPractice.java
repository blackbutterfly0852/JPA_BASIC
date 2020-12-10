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

            String jpql = "select m from Member m where m.age > 18";
            List<Member> jpqlList = em.createQuery(jpql, Member.class).getResultList();
            System.out.println("result.size() = " + jpqlList.size());


            // 2. QueryDSL
            em.clear();
            JPAQueryFactory query =new JPAQueryFactory(em);
            QMember m = QMember.member;
            List<Member> queryDSLList = query.selectFrom(m)
                    .where(m.age.gt(18))
                    .orderBy(m.name.desc())
                    .fetch();
            System.out.println("list.size() = " + queryDSLList.size());


            // 3. Native SQL
            String sql = "SELECT MEMBER_ID, AGE, TEAM_ID, NAME FROM MEMBER WHERE NAME = '김동우1'";
            List<Member> nativeList =  em.createNativeQuery(sql, Member.class).getResultList();
            System.out.println("nativeList.size() = " + nativeList.size());

            // 4. 집합과 정렬
            String sql2 = "select COUNT(m), SUM(m.age), AVG(m.age), MAX(m.age), MIN(m.age) from Member m";
            Query setResult = em.createQuery(sql2);
            Object o = setResult.getSingleResult();
            Object[] result = (Object[]) o;
            for(Object object : result){
                System.out.println("집합과 정렬 = " + object);
            }


            // 5. TypeQuery, Query
            // 반환 타입이 명확할 때
            TypedQuery<Member> query1 = em.createQuery("SELECT m FROM Member m", Member.class);
            // 반환 타입이 불명확할 때
            Query query2 = em.createQuery("SELECT m.name, m.age from Member m");

            // 6. 파라미터 바인딩 - 이름 기준, 위치 기준 -> 이름 기준으로 사용할 것
            String sql3 = "select m from Member m where m.name =:name";
            List<Member> member = em.createQuery(sql3,Member.class).setParameter("name", "김동우1").getResultList();
            System.out.println("member.size() : " + member.size());

            // 7. 프로젝션
            // 1) Query 타입으로 조회
            List resultList1 = em.createQuery("select m.name, m.age from Member m").getResultList();
            Object o1 = resultList1.get(0);
            Object[] resultO1 = (Object[]) o1;
            System.out.println("name = " + resultO1[0]);
            System.out.println("name = " + resultO1[1]);

            // 2) Object[] 타입으로 조회
            List<Object[]> resultList2 = em.createQuery("select m.name, m.age from Member m").getResultList();
            Object[] resultO2 = resultList2.get(0);
            System.out.println("name = " + resultO2[0]);
            System.out.println("name = " + resultO2[1]);
            // 3) new 명령어로 조회 - 단순 값을 DTO로 바로 조회
            // 패키지 명을 포함한 전체 클래스 명 입력
            // 순서와 타입이 일치하는 생성자 필요
            List<MemberDTO> resultList3 = em.createQuery("select new jpqlPractice.MemberDTO(m.name, m.age) from Member m", MemberDTO.class).getResultList();
            MemberDTO resultO3 = resultList3.get(0);
            System.out.println("name = " + resultO3.getName());
            System.out.println("name = " + resultO3.getAge());

            // 8. 페이징 API
            String pagingQuery = "select m from Member m order by m.name desc";
            List<Member> resultList = em.createQuery(jpql, Member.class)
                        .setFirstResult(10)
                        .setMaxResults(20)
                        .getResultList();




        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
