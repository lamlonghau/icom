package com.icommerce.shopcard.core.shopcard.usecase.impl;

import com.icommerce.shopcard.core.shared.CreationValidationGroup;
import com.icommerce.shopcard.core.shopcard.ShopCart;
import com.icommerce.shopcard.core.shopcard.port.ShopCardPort;
import com.icommerce.shopcard.core.shopcard.usecase.CreateShopCardUseCase;

public class CreateShopCardUseCaseImpl implements CreateShopCardUseCase {

    private ShopCardPort shopCardPort;

    public CreateShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(ShopCart shopCart) {
        shopCart.validateSelf(CreationValidationGroup.class);
        return shopCardPort.create(shopCart);
    }
}
