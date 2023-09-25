package com.gainsight.JavaCaseStudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "orderid")
    private int orderId;

    @Column(name = "cartid")
    private int cartId;
    @Column(name = "productid")
    private int productId;
    @Column(name = "quantity")
    private int quantity;
    Orders(){};

    public Orders(int orderId,int cartId, int productId, int quantity) {
        this.orderId = orderId;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
