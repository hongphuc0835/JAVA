package generics_toi_uu_code.entity;

import java.util.Date;

public class Order extends  Entity<Integer>{
    private int order_id;
    private int customer_id;
    private Date orderDate;
    private double total;

    public Order(int order_id, int customer_id, Date orderDate, double total) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.orderDate = orderDate;
        this.total = total;
    }

    public Order(Integer id, int order_id, int customer_id, Date orderDate, double total) {
        super(id);
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.orderDate = orderDate;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", customer_id=" + customer_id +
                ", orderDate=" + orderDate +
                ", total=" + total +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
