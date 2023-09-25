package com.gainsight.JavaCaseStudy.repository;

import com.gainsight.JavaCaseStudy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
List<Product> findByProductNameContaining(String query);
}
