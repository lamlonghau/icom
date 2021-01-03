package com.icommerce.shopcard.delivery;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.delivery.dto.BaseResponse;

import java.util.List;

public interface ShopCardController {

    BaseResponse<List<ShopCart>> findAll();
    BaseResponse<ShopCart> findByCustomer(String customer);
    BaseResponse<ShopCart> update(String customer, ShopCart dto);
    BaseResponse<ShopCart> create(ShopCart dto);
    BaseResponse<Void> delete(String customer);
}
