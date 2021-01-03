package com.icommerce.shopcard.core.usecase;

import com.icommerce.shopcard.core.ShopCart;

public interface UpdateShopCardUseCase {

    ShopCart execute(String customer, ShopCart shopCart);
}
