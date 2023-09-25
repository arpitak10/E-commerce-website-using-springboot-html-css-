package com.gainsight.JavaCaseStudy.service;

import com.gainsight.JavaCaseStudy.entity.Product;
import com.gainsight.JavaCaseStudy.repository.CartItemsRepository;
import com.gainsight.JavaCaseStudy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RestTemplate restTemplate;
    //USING FOR JOINING
    @Autowired
    CartItemsRepository cartItemsRepository;
    @Autowired
    CartItemsService cartItemsService;
    //fetch all the products
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    //shows the product by using productId
    @Transactional(readOnly = true)
    public Product getProductById(int productId) {
        Optional<Product> op = productRepository.findById(productId);
        if (op.isPresent())
            return op.get();
        throw new RuntimeException("Product does not exist");
    }
    //search the products by product Name
    @Transactional(readOnly = true)
    public List<Product> searchProducts(String query){
        return productRepository.findByProductNameContaining(query);
    }
}

