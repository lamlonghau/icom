package com.icommerce.shopcard.core.usecase;

import com.icommerce.shopcard.core.ShopCart;

public interface FindShopCardsByCustomerUseCase {

    ShopCart execute(String customer);
}
