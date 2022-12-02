package com.example.masterRobot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="cart_items")
public class CartItem implements Serializable {
    @Id
    long cart_item_id;
    long cust_id;
    long item_id;
    long quantity;


    public long getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getQuantity(){
        return this.quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
