package com.gainsight.JavaCaseStudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cartitems")
public class CartItems {

    @Column(name = "itemsid")
    private int itemsId;
    @Column(name = "cartid")
    private int cartId;
    @Id
    @Column(name = "productid")
    private int productId;
    private int quantity;
    CartItems(){}

    public CartItems(int cartId, int productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
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
}
