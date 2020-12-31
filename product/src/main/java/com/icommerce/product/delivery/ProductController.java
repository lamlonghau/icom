package com.icommerce.product.delivery;

import com.icommerce.product.delivery.dto.BaseResponse;
import com.icommerce.product.delivery.dto.ProductDto;

import java.util.List;

public interface ProductController {

    BaseResponse<List<ProductDto>> find(String search, String sort, Integer size, Integer page);
    BaseResponse<String> create(ProductDto dto);
}
