package com.icommerce.shopcard.core.shopcard.usecase.impl;

import com.icommerce.shopcard.core.shopcard.ShopCart;
import com.icommerce.shopcard.core.shopcard.port.ShopCardPort;
import com.icommerce.shopcard.core.shopcard.usecase.FindAllShopCardsUseCase;

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
