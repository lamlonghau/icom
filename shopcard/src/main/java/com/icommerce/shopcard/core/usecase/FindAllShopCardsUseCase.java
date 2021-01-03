package com.icommerce.shopcard.core.usecase;

import com.icommerce.shopcard.core.ShopCart;

import java.util.List;

public interface FindAllShopCardsUseCase {

    List<ShopCart> execute();
}
