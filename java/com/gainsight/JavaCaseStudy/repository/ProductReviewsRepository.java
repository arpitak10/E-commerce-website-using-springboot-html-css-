package com.gainsight.JavaCaseStudy.repository;

import com.gainsight.JavaCaseStudy.entity.ProductReviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductReviewsRepository extends MongoRepository<ProductReviews,Integer> {

    List<ProductReviews> findByProductId(int productId);


}
