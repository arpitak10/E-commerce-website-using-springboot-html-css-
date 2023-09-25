package com.gainsight.JavaCaseStudy.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.DataAmount;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "ProductReviews")
public class ProductReviews {
    @Id
    private String id;

    private int productId;

    private String reviews;
    private int ratings;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductReviews(String id, int productId, String reviews, int ratings) {
        this.id = id;
        this.productId = productId;
        this.reviews = reviews;
        this.ratings = ratings;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
