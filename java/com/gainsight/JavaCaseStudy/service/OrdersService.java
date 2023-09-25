package com.gainsight.JavaCaseStudy.service;

import com.gainsight.JavaCaseStudy.entity.CartItems;
import com.gainsight.JavaCaseStudy.entity.Orders;
import com.gainsight.JavaCaseStudy.repository.CartItemsRepository;
import com.gainsight.JavaCaseStudy.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    CartItemsRepository cartItemsRepository;
    @Transactional
    //add certItems to order table then delete from cartItems table
    public boolean addCartItemsInOrderTable(int cartid){
        List<CartItems> c= cartItemsRepository.findAllByCartId(cartid);
        List<Orders> od = new ArrayList<>();
        int val=1;
        for(CartItems items:c){
            Orders o = new Orders(val,items.getCartId(), items.getProductId(), items.getQuantity());
            ordersRepository.save(o);
            cartItemsRepository.deleteById(items.getProductId());
        }

        return true;
    }
}
