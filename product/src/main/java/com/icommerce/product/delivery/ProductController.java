package com.icommerce.product.delivery;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.delivery.dto.BaseResponse;

import java.util.List;

public interface ProductController {

    BaseResponse<List<Product>> find(String search, String sort, Integer size, Integer page);
    BaseResponse<String> create(Product dto);
    BaseResponse<Product> findById(String id);
    BaseResponse<Product> update(String id, Product dto);
}
