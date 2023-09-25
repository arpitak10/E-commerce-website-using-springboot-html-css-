package com.gainsight.JavaCaseStudy.repository;

import com.gainsight.JavaCaseStudy.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItems,Integer> {
    CartItems findByCartIdAndProductId(int cartId,int productId);
    public Optional<CartItems> getCartItemsByProductId(int productid);
    boolean existsByProductId(int productId);
    List<CartItems> findAllByCartId(int cartId);
}
