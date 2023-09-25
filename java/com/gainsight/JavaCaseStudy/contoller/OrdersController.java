package com.gainsight.JavaCaseStudy.contoller;

import com.gainsight.JavaCaseStudy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class OrdersController {
    @Autowired
    OrdersService ordersService;
    //it copy the data from cartTable to orderTable when user click on s
    @PostMapping("/submit/{cartId}")
    public ResponseEntity<String> addItemsInOrders(@PathVariable int cartId){
        ordersService.addCartItemsInOrderTable(cartId);
        return ResponseEntity.ok("Cart copied successfully");
    }
}
