package com.icommerce.shopcard.core.shopcard.usecase;

import com.icommerce.shopcard.core.shopcard.ShopCart;

public interface UpdateShopCardUseCase {

    ShopCart execute(String customer, ShopCart shopCart);
}
