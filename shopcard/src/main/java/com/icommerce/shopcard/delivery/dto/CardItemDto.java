package com.icommerce.shopcard.delivery.dto;

public class CardItemDto {

    private ProductDto productDto;
    private Long quantity;

    public ProductDto getProduct() {
        return productDto;
    }

    public void setProduct(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
