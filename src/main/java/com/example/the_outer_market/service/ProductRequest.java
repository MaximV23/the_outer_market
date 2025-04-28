package com.example.the_outer_market.service;

public class ProductRequest {
    private Long productId;
    private int quantity;

    public ProductRequest() {}

    public ProductRequest(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    public void setProductId(Long productId) { this.productId = productId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}

