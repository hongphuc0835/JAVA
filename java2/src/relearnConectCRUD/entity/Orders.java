package relearnConectCRUD.entity;

import java.util.Date;

public class Orders extends Entity<Integer>{
    private int order_id;
    private int customer_id;
    private Date orderDate;
    private double total;

    public Orders(Integer id) {
        super(id);
    }

    public Orders() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public Orders(int order_id, int customer_id, Date orderDate, double total) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.orderDate = orderDate;
        this.total = total;
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
