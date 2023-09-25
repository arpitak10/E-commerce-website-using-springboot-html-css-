package com.gainsight.JavaCaseStudy.contoller;
import com.gainsight.JavaCaseStudy.entity.CartItems;
import com.gainsight.JavaCaseStudy.entity.Product;
import com.gainsight.JavaCaseStudy.helper.CartItemsWithProduct;
import com.gainsight.JavaCaseStudy.service.CartItemsService;
import com.gainsight.JavaCaseStudy.service.ProductService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class CartItemsController {

    @Autowired
    CartItemsService cartItemsService;
    @Autowired
    ProductService productService;

    @PostMapping(value = "/cartPage")
    public ResponseEntity<String> addProduct(@RequestBody CartItems cartItems) {
        /*
        cartItemsService.addProductDetails(cartItems);
        return HttpStatus.OK;

         */
        boolean productExists = cartItemsService.doesProductExist(cartItems.getProductId());
        if (productExists) {
            // Product exists, update the value
            cartItemsService.updateProductDetails(cartItems);
            return ResponseEntity.ok("Product updated successfully");
        } else {
            // Product doesn't exist, insert the value
            cartItemsService.addProductDetails(cartItems);
            return ResponseEntity.ok("Product inserted successfully");
        }
    }
    //cartPage having details of cart table and productTable
    @GetMapping(value = "/cart", produces = "application/json")

    public ResponseEntity<List<CartItemsWithProduct>> getAllProducts() {
        List<CartItems> cartItemsList = cartItemsService.getAllCartItems();
        List<CartItemsWithProduct> b = new ArrayList<>();
        for(CartItems c:cartItemsList){
            int productId = c.getProductId();
            Product product = productService.getProductById(productId);
            CartItemsWithProduct elements = new CartItemsWithProduct(c,product);
            b.add(elements);

        }


        return new ResponseEntity<>(b, HttpStatus.OK);
    }

   //totalamount function during checkout
   @GetMapping(value = "/totalamount")
   public double checkOutPage(){
       List<CartItems> cartItemsList = cartItemsService.getAllCartItems();
       List<CartItemsWithProduct> b = new ArrayList<>();
       for(CartItems c:cartItemsList){
           int productId = c.getProductId();
           Product product = productService.getProductById(productId);
           CartItemsWithProduct elements = new CartItemsWithProduct(c,product);
           b.add(elements);

       }
        double totalAmount = 0;
       for (CartItemsWithProduct list:b){
            totalAmount +=list.getProduct().getProductPrice()*list.getCartItems().getQuantity();
       }
       return totalAmount;
   }
   //adding the element in a cart
   @PostMapping(value = "addinCart/{productid}/{quantity}")
    public void addQuantityinCart(@PathVariable int productid,@PathVariable int quantity){
        cartItemsService.addQuantityinCart(productid,quantity);
   }
   //delete the element from the cart
   @PostMapping(value="deleteFromCart/{productId}")
    public void deleteFromCart(@PathVariable int productId){
        cartItemsService.deleteCartById(productId);
   }
    @GetMapping(value="/cart/{cartId}",produces="application/json")
    public ResponseEntity<List<CartItems>>  getItemsByCartId(@PathVariable int cartId){
        List<CartItems> c = cartItemsService.getCartItemsByCartId(cartId);
        return new ResponseEntity<List<CartItems>>(c,HttpStatus.OK);
    }
}































/*
     @PostMapping(value = "/upsert")
    public ResponseEntity<CartItems> updateCartItems(
            @RequestParam int cartId,
            @RequestParam int productId,
            @RequestParam int itemsId,
            @RequestParam int quantity
    ){
        CartItems cartItems = cartItemsService.updateCartItems(cartId,productId,itemsId,quantity);
        return new ResponseEntity<>(cartItems,HttpStatus.OK);
    }*/
    /*
    @PostMapping(value = "/cartPage")
    public ResponseEntity<String> handleButtonClicked(@RequestBody Map<Integer,Integer> buttonClickedData){
        String responseMessage = "Received buttonClicked";
        buttonClickedData.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
        cartItemsService.updateDetailsCartItems(buttonClickedData);
        if(buttonClickedData.isEmpty()){
            responseMessage = "Not Received buttonClicked";
        }

        return ResponseEntity.ok(responseMessage);
    }
     */