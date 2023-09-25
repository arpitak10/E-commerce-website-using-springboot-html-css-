package com.gainsight.JavaCaseStudy.service;

import com.gainsight.JavaCaseStudy.entity.Cart;
import com.gainsight.JavaCaseStudy.entity.CartItems;
import com.gainsight.JavaCaseStudy.entity.Product;
import com.gainsight.JavaCaseStudy.helper.CartItemsWithProduct;
import com.gainsight.JavaCaseStudy.repository.CartItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemsService {

    @Autowired
    CartItemsRepository cartItemsRepository;
    @Transactional
    public void addProductDetails(CartItems c) {
        int userid = 101;
        int quantity = 1;
        //int CartId = cartService.getCartIdByUserId(userid);
        //CartItems existingcartItems = cartItemsRepository.findByCartIdAndProductId(CartId,productId);
            CartItems newCartItem = new CartItems(c.getCartId(), c.getProductId(), c.getQuantity());
            cartItemsRepository.save(newCartItem);
    }
    //fetch all the cartItems details
    @Transactional(readOnly = true)
    public List<CartItems> getAllCartItems() {
        return cartItemsRepository.findAll();
    }
    //fetch cartItems by using productId
    @Transactional(readOnly = true)
    public CartItems getCartItemsbyProductId(int productId) {
        Optional<CartItems> op = cartItemsRepository.findById(productId);
        if (op.isPresent())
            return op.get();
        throw new RuntimeException("Product does not exist");

}

//check whether product exists or not by using productId
    @Transactional(readOnly = true)

    public boolean doesProductExist(int productId){
        return cartItemsRepository.existsByProductId(productId);
    }
    //delete the cartItems by productId from cartTable
    @Transactional
    public boolean deleteCartById(int productId) {
        long count = cartItemsRepository.count();
        cartItemsRepository.deleteById(productId);
        return count > cartItemsRepository.count();
    }
    //if product is already exist in the cartItems then update the cartItems
    @Transactional
    public void updateProductDetails(CartItems cartItems) {
        // Check if the CartItems entry already exists by product ID
        int productId = cartItems.getProductId();
        boolean productExists = cartItemsRepository.existsByProductId(productId);

        if (productExists) {
            CartItems existingCartItem = getCartItemsbyProductId(productId);

            existingCartItem.setQuantity(cartItems.getQuantity());
            if (cartItems.getQuantity() == 0) {
                deleteCartById(cartItems.getProductId());
            } else {

                cartItemsRepository.save(existingCartItem);
            }

        } else {

            cartItemsRepository.save(cartItems);
        }

    }
    //update the qunatity of product in cartTable while in cartPage
    @Transactional
    public void addQuantityinCart(int productId,int quantity){
        CartItems c =getCartItemsbyProductId(productId);
        c.setQuantity(quantity);
    }
    //fetch all the cartItems by using cartId
    @Transactional(readOnly = true)
    public List<CartItems> getCartItemsByCartId(int cartId) {
        return cartItemsRepository.findAllByCartId(cartId);
    }


}
