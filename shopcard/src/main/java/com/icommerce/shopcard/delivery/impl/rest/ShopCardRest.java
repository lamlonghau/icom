package com.icommerce.shopcard.delivery.impl.rest;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.core.shared.ConstantUtils;
import com.icommerce.shopcard.core.usecase.*;
import com.icommerce.shopcard.delivery.ShopCardController;
import com.icommerce.shopcard.delivery.dto.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ConstantUtils.API_VERSION_1 + ConstantUtils.RESOURCE_SHOP_CARD)
public class ShopCardRest implements ShopCardController {

    @Autowired
    private FindAllShopCardsUseCase findAllShopCardsUseCase;
    @Autowired
    private UpdateShopCardUseCase updateShopCardUseCase;
    @Autowired
    private FindShopCardsByCustomerUseCase findShopCardsByCustomerUseCase;
    @Autowired
    private DeleteShopCardUseCase deleteShopCardUseCase;
    @Autowired
    private CreateShopCardUseCase createShopCardUseCase;

    @PostMapping
    @Override
    public BaseResponse<ShopCart> create(@RequestBody ShopCart dto) {
        final ShopCart result = createShopCardUseCase.execute(dto);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @GetMapping
    @Override
    public BaseResponse<List<ShopCart>> findAll() {
        final List<ShopCart> result = findAllShopCardsUseCase.execute();
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @GetMapping("/{customer}")
    @Override
    public BaseResponse<ShopCart> findByCustomer(@PathVariable("customer") String customer) {
        final ShopCart result = findShopCardsByCustomerUseCase.execute(customer);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @PutMapping("/{customer}")
    @Override
    public BaseResponse<ShopCart> update(@PathVariable("customer") String customer,
                                            @RequestBody ShopCart dto) {
        final ShopCart result = updateShopCardUseCase.execute(customer, dto);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @DeleteMapping("/{customer}")
    @Override
    public BaseResponse<Void> delete(@PathVariable("customer") String customer) {
        deleteShopCardUseCase.execute(customer);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS);
    }
}
