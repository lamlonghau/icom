package com.icommerce.shopcard.delivery.impl.rest;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.core.shared.ConstantUtils;
import com.icommerce.shopcard.core.usecase.*;
import com.icommerce.shopcard.delivery.ShopCardController;
import com.icommerce.shopcard.delivery.converter.ShopCardDeliveryConverter;
import com.icommerce.shopcard.delivery.dto.BaseResponse;
import com.icommerce.shopcard.delivery.dto.ShopCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ConstantUtils.APPLICATION_NAME + ConstantUtils.API_VERSION_1 + ConstantUtils.RESOURCE_SHOP_CARD)
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
    public BaseResponse<ShopCardDto> create(@RequestBody ShopCardDto shopCardDto) {
        final ShopCart model = createShopCardUseCase.execute(
                ShopCardDeliveryConverter.fromDtoToModel.apply(shopCardDto));
        final ShopCardDto result = ShopCardDeliveryConverter.fromModelToDto.apply(model);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @GetMapping
    @Override
    public BaseResponse<List<ShopCardDto>> findAll() {
        final List<ShopCardDto> result = findAllShopCardsUseCase.execute()
                .stream().map(ShopCardDeliveryConverter.fromModelToDto)
                .collect(Collectors.toUnmodifiableList());
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @GetMapping("/{customer}")
    @Override
    public BaseResponse<ShopCardDto> findByCustomer(@PathVariable("customer") String customer) {
        final ShopCart model = findShopCardsByCustomerUseCase.execute(customer);
        final ShopCardDto result = ShopCardDeliveryConverter.fromModelToDto.apply(model);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @PutMapping("/{customer}")
    @Override
    public BaseResponse<ShopCardDto> update(@PathVariable("customer") String customer,
                                            @RequestBody ShopCardDto shopCardDto) {
        final ShopCart model = updateShopCardUseCase.execute(customer,
                ShopCardDeliveryConverter.fromDtoToModel.apply(shopCardDto));
        final ShopCardDto result = ShopCardDeliveryConverter.fromModelToDto.apply(model);
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS, result);
    }

    @DeleteMapping("/{customer}")
    @Override
    public BaseResponse<Void> delete(@PathVariable("customer") String customer) {
        return new BaseResponse<>(String.valueOf(HttpStatus.OK), ConstantUtils.SUCCESS);
    }
}
