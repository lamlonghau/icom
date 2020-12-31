package com.icommerce.product.delivery.impl.rest;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.usecase.CreateProductUseCase;
import com.icommerce.product.core.product.usecase.FindProductsUseCase;
import com.icommerce.product.core.shared.ConstantUtils;
import com.icommerce.product.delivery.ProductController;
import com.icommerce.product.delivery.converter.ProductDeliveryConverter;
import com.icommerce.product.delivery.dto.BaseResponse;
import com.icommerce.product.delivery.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ConstantUtils.APPLICATION_NAME + ConstantUtils.API_VERSION_1 + ConstantUtils.RESOURCE_PRODUCT)
public class ProductRest implements ProductController {

    @Autowired
    private CreateProductUseCase createProductUseCase;
    @Autowired
    private FindProductsUseCase findProductsUseCase;

    @GetMapping
    @Override
    public BaseResponse<List<ProductDto>> find(@RequestParam(value = "search", required = false) String search,
                                               @RequestParam(value = "sort", required = false) String sort,
                                               @RequestParam(value = "size", required = false, defaultValue = "" + Integer.MAX_VALUE) Integer size,
                                               @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        final List<ProductDto> response = findProductsUseCase.execute(search, sort, size, page)
                .stream().map(ProductDeliveryConverter.fromProductToProductDto)
                .collect(Collectors.toUnmodifiableList());
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, "Search result", response);
    }

    @PostMapping
    @Override
    public BaseResponse<String> create(@RequestBody ProductDto dto) {
        final Product product = ProductDeliveryConverter.fromProductDtoToProduct.apply(dto);
        final String id = createProductUseCase.execute(product);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, id);
    }
}
