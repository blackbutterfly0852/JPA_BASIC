package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;
    // 1. 데이터 중심 설계
    //@Column(name = "ORDER_ID")
    //private Long orderId;
    //@Column(name = "ITEM_ID")
    //private Long itemId;

    // 2. 객체 지향 설계
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;


    private int orderPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 1. 데이터 중심 설계
    //public Long getOrderId() {
    //return orderId;
    //}

    //public void setOrderId(Long orderId) {
    //this.orderId = orderId;
    //}

    //public Long getItemId() {
    //return itemId;
    //}

    //public void setItemId(Long itemId) {
    //this.itemId = itemId;
    //}

    // 2. 객체 지향 설계
    public Item getItem() {
        return item;
    }

    public Order getOrder() {
        return order;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
