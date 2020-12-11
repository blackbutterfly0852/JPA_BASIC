package jpqlPractice;



import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.*;
import java.util.List;

public class JpqlPractice_2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx =  em.getTransaction();
        tx.begin();

        try{

            // 9. 조인
            // 1) 내부조인
            Team teamA = new Team();
            teamA.setName("A");
            em.persist(teamA);
            Member memberA = new Member();
            memberA.setName("A");
            memberA.setAge(10);
            memberA.setTeam(teamA);
            em.persist(memberA);
            em.flush();

            String sql6 = "select m from Member m INNER JOIN m.team t";
            List<Member> query12List = em.createQuery(sql6, Member.class).getResultList();
            System.out.println("INNER JOIN.SIZE() = " + query12List.size());

            // 2) 외부조인
            String sql7 = "select m from Member m LEFT OUTER JOIN m.team t";
            List<Member> query13List = em.createQuery(sql7, Member.class).getResultList();
            System.out.println("LEFT OUTER JOIN.SIZE() = " + query13List.size());

            // 3) 세타조인(==막조인)
            String sql8 = "select count(m) from Member m, Team t where m.name = t.name";
            Long query14List = em.createQuery(sql8, Long.class).getSingleResult();
            System.out.println("THETA OUTER JOIN.SIZE() = " + query14List);

            // 4) ON 절을 활용한 조인
            // 조인대상 필터링
            // ex) 회원과 팀을 조인하면서, 팀 이름이 A인 팀만 조인
            String sql9 = "select m, t from Member m LEFT OUTER JOIN m.team t on t.name = 'A'";
            List<Object[]> query15List = em.createQuery(sql9).getResultList();
            for(Object[] o : query15List){
               Member member = (Member) o[0];
               Team team = (Team) o[1];
               System.out.println("member = " + member.toString());
               System.out.println("team = " + team.toString());
            }
            System.out.println("ON JOIN_1.SIZE() = " + query15List.size());

            // 연관관계 없는 엔티티 외부 조인
            String sql10 = "select m, t from Member m LEFT outer JOIN Team t on m.name = t.name";
            List<Object[]> query16List = em.createQuery(sql10).getResultList();
            for(Object[] o : query16List){
                Member member = (Member) o[0];
                Team team = (Team) o[1];
                System.out.println("member = " + member.toString());
                System.out.println("team = " + team.toString());
            }
            System.out.println("ON JOIN_2.SIZE() = " + query16List.size());


            // 10. 서브쿼리
            // 1) 나이가 평균보다 많은 회원 -> 같은 Member 엔티티라도 m, m2를 분리해서 사용해야 성능상 좋음.
            String sql11 = "select m from Member m where m.age >= (select avg(m2.age) from Member m2)";
            List<Member> query17List = em.createQuery(sql11, Member.class).getResultList();
            System.out.println("SUBQUERY_1.SIZE() = " + query17List.size());

            // 2) 한 건이라도 주문한 고객 -> Member를 서브쿼리까지 가지고 왔다 -> 성능상 않좋음.

            Product product = new Product();
            product.setName("물품");
            product.setPrice(10000);
            product.setStockAmount(10);
            em.persist(product);

            Order order = new Order();
            order.setMember(memberA);
            order.setProduct(product);
            order.setOrderAmount(11);
            em.persist(order);



            String sql12 = "select m from Member m where (select count(o) from Order o where m = o.member) > 0";
            List<Member> query18List = em.createQuery(sql12, Member.class).getResultList();
            System.out.println("SUBQUERY_2.SIZE() = " + query18List.size());

            // 3) 팀A 소속인 회원 -> EXSISTS 사용 : 서브쿼리에 결과가 존재하면 참
            String sql13 = "select m from Member m where exists (select t from m.team t where t.name = 'A')";
            List<Member> query19List = em.createQuery(sql13, Member.class).getResultList();
            System.out.println("SUBQUERY_3.SIZE() = " + query19List.size());

            // 4) 전체 상품 각각의 재고보다 주문량이 많은 주문들. -> ALL 사용 : 모두 만족하면 참
            String sql14 = "select o from Order o where o.orderAmount > All (select p.stockAmount from Product p)";
            List<Order> query20List = em.createQuery(sql14, Order.class).getResultList();
            System.out.println("SUBQUERY_4.SIZE() = " + query20List.size());

            // 5) 어떤 팀이든 팀에 소속된 회원 -> ANY, SOME 사용 : 같은 의미, 조건을 하나라도 만족하면 참
            String sql15 = "select m from Member m where m.team = ANY (select t from Team t)";
            List<Member> query21List = em.createQuery(sql15, Member.class).getResultList();
            System.out.println("SUBQUERY_5.SIZE() = " + query21List.size());

            // 6) Member가 속해 있는 TEAM -> IN 사용 : 서브쿼리의 결과 중 하나라도 같은 것이 있으면 참
            String sql16 = "select t from Team t where t.id in (select m.team from Member m)";
            List<Team> query22List = em.createQuery(sql16, Team.class).getResultList();
            System.out.println("SUBQUERY_6.SIZE() = " + query22List.size());

            // 11. 조건식




        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();

    }
}
