package com.gainsight.JavaCaseStudy.contoller;

import com.gainsight.JavaCaseStudy.entity.ProductReviews;
import com.gainsight.JavaCaseStudy.repository.ProductReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductReviewsController {


    @Autowired
    ProductReviewsRepository productReviewsRepository;
   //get review by using produductId
    @GetMapping("/mongodb")
    public List<ProductReviews> getProductReviews(){
        return productReviewsRepository.findAll();
    }
}
