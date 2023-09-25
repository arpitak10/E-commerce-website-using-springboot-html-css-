package com.gainsight.JavaCaseStudy.helper;

import com.gainsight.JavaCaseStudy.entity.CartItems;
import com.gainsight.JavaCaseStudy.entity.Product;

public class CartItemsWithProduct {
    private CartItems cartItems;
    private Product product;
    public CartItemsWithProduct(){}

    public CartItemsWithProduct(CartItems cartItems, Product product) {
        this.cartItems = cartItems;
        this.product = product;
    }

    public CartItems getCartItems() {
        return cartItems;
    }

    public void setCartItems(CartItems cartItems) {
        this.cartItems = cartItems;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
