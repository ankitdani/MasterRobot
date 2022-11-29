package com.example.masterRobot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name="cust_order")
public class CustOrder {
    @Id
    @Column(name = "order_id", nullable = false)
    private long orderId;
    private long custId;
    private Date dateOfOrder;
    private Date shippedDate;
    private long shippingFee;

    public CustOrder() {
    }

    public CustOrder(long orderId, long custId, Date dateOfOrder, Date shippedDate, long shippingFee) {
        this.orderId = orderId;
        this.custId = custId;
        this.dateOfOrder = dateOfOrder;
        this.shippedDate = shippedDate;
        this.shippingFee = shippingFee;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public long getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(long shippingFee) {
        this.shippingFee = shippingFee;
    }
}
