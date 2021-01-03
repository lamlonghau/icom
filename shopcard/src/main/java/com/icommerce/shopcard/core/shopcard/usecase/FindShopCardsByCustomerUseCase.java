package com.icommerce.shopcard.core.shopcard.usecase;

import com.icommerce.shopcard.core.shopcard.ShopCart;

public interface FindShopCardsByCustomerUseCase {

    ShopCart execute(String customer);
}
