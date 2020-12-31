package com.icommerce.product.delivery.converter;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.delivery.dto.ProductDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public interface ProductDeliveryConverter {

    Function<Product, ProductDto> fromProductToProductDto = product -> {
        final ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(product, dto);
        return dto;
    };

    Function<ProductDto, Product> fromProductDtoToProduct = dto -> {
        final Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    };
}
