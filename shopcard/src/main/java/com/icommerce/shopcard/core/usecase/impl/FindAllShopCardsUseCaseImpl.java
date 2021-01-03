package com.icommerce.shopcard.core.usecase.impl;

import com.icommerce.shopcard.core.ShopCart;
import com.icommerce.shopcard.core.port.ShopCardPort;
import com.icommerce.shopcard.core.usecase.FindAllShopCardsUseCase;

import java.util.List;

public class FindAllShopCardsUseCaseImpl implements FindAllShopCardsUseCase {

    private ShopCardPort shopCardPort;

    public FindAllShopCardsUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public List<ShopCart> execute() {
        return shopCardPort.findAll();
    }
}
