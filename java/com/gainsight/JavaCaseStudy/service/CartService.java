package com.gainsight.JavaCaseStudy.service;

import com.gainsight.JavaCaseStudy.entity.Cart;
import com.gainsight.JavaCaseStudy.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Transactional(readOnly = true)
    public int getCartIdByUserId(int userId){
        Optional<Cart> c = cartRepository.findById(userId);
        if(c.isPresent())
            return c.get().getCartId();
        return 0;
    }
}
