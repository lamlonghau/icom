package com.icommerce.shopcard.delivery.converter;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.delivery.dto.ShopCardDto;
import org.springframework.beans.BeanUtils;

import java.util.function.Function;

public interface ShopCardDeliveryConverter {

    Function<ShopCardDto, ShopCart> fromDtoToModel = dto -> {
        final ShopCart model = new ShopCart();
        BeanUtils.copyProperties(dto, model);
        return model;
    };

    Function<ShopCart, ShopCardDto> fromModelToDto = model -> {
        final ShopCardDto dto = new ShopCardDto();
        BeanUtils.copyProperties(model, dto);
        return dto;
    };
}
