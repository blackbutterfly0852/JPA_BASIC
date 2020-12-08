package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    // 1. 데이터 중심 설계
    // @Column(name = "MEMBER_ID")
    // private Long memberId;

    // 2. 객체 지향 설계
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // 3. 양방향 연관관계 : 주문서를 보고 주문목록을 보는 것은 비즈니스적으로 의미 있다.
    // OrderItem 테이블의 order_id와 매핑 한게 OrderItem.class의 Order가 주인이다.
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    // 4. 연관관계 편의 메소드 -> 양방향 연관관계 설정
    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 1. 데이터 중심 설계
    // public Long getMemberId() {
    //return memberId;
    //}
    // public void setMemberId(Long memberId) {
    //this.memberId = memberId;
    //}

    // 2. 객체 지향 설계
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
