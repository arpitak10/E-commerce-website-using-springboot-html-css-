package com.gainsight.JavaCaseStudy.contoller;

import com.gainsight.JavaCaseStudy.entity.Product;
import com.gainsight.JavaCaseStudy.service.CartItemsService;
import com.gainsight.JavaCaseStudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/product")
@RestController
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CartItemsService cartItemsService;
    //shows all the product
    @GetMapping(value="/",produces="application/json")

    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }
    //shows product detals by using product Id
    @GetMapping(value="/{productId}",produces="application/json")
    public ResponseEntity<Product> getProductById(@PathVariable int productId){
        Product p = productService.getProductById(productId);
        return new ResponseEntity<Product>(p,HttpStatus.OK);

    }
    //search the products by using productName
    @GetMapping(value = "/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(value = "query", required = true) String query) {
        List<Product> results = productService.searchProducts(query);
        return ResponseEntity.ok(results);
    }


}
