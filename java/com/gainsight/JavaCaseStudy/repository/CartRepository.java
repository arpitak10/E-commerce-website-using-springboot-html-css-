package com.gainsight.JavaCaseStudy.repository;

import com.gainsight.JavaCaseStudy.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {
}
