package com.icommerce.shopcard.delivery;

import com.icommerce.shopcard.delivery.dto.BaseResponse;
import com.icommerce.shopcard.delivery.dto.ShopCardDto;

import java.util.List;

public interface ShopCardController {

    BaseResponse<List<ShopCardDto>> findAll();
    BaseResponse<ShopCardDto> findByCustomer(String customer);
    BaseResponse<ShopCardDto> update(String customer, ShopCardDto shopCardDto);
    BaseResponse<ShopCardDto> create(ShopCardDto shopCardDto);
    BaseResponse<Void> delete(String customer);
}
