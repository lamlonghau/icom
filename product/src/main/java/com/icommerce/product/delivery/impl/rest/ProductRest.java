package com.icommerce.product.delivery.impl.rest;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.usecase.CreateProductUseCase;
import com.icommerce.product.core.product.usecase.FindProductsUseCase;
import com.icommerce.product.core.product.usecase.UpdateProductUseCase;
import com.icommerce.product.core.shared.ConstantUtils;
import com.icommerce.product.delivery.ProductController;
import com.icommerce.product.delivery.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ConstantUtils.API_VERSION_1 + ConstantUtils.RESOURCE_PRODUCT)
public class ProductRest implements ProductController {

    @Autowired
    private CreateProductUseCase createProductUseCase;
    @Autowired
    private FindProductsUseCase findProductsUseCase;
    @Autowired
    private UpdateProductUseCase updateProductUseCase;

    @GetMapping
    @Override
    public BaseResponse<List<Product>> find(@RequestParam(value = "search", required = false) String search,
                                            @RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "size", required = false, defaultValue = "" + Integer.MAX_VALUE) Integer size,
                                            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        final List<Product> response = findProductsUseCase.execute(search, sort, size, page);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, "Search result", response);
    }

    @PostMapping
    @Override
    public BaseResponse<String> create(@RequestBody Product product) {
        final String id = createProductUseCase.execute(product);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, id);
    }

    @GetMapping("/{id}")
    @Override
    public BaseResponse<Product> findById(@PathVariable String id) {
        return new BaseResponse<>(String.valueOf(HttpStatus.OK),
                ConstantUtils.SUCCESS, findProductsUseCase.execute(id));
    }

    @PutMapping("/{id}")
    @Override
    public BaseResponse<Product> update(@PathVariable String id,
                                        @RequestBody Product dto) {
        return new BaseResponse<>(String.valueOf(HttpStatus.OK),
                ConstantUtils.SUCCESS, updateProductUseCase.execute(id, dto));
    }
}
