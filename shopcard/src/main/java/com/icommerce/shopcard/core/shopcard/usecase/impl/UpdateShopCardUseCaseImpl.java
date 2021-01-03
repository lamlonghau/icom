package com.icommerce.shopcard.core.shopcard.usecase.impl;

import com.icommerce.shopcard.core.shared.UpdatingValidationGroup;
import com.icommerce.shopcard.core.shopcard.ShopCart;
import com.icommerce.shopcard.core.shopcard.port.ShopCardPort;
import com.icommerce.shopcard.core.shopcard.usecase.UpdateShopCardUseCase;

public class UpdateShopCardUseCaseImpl implements UpdateShopCardUseCase {

    private ShopCardPort shopCardPort;

    public UpdateShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public ShopCart execute(String customer, ShopCart shopCart) {
        shopCart.setCustomer(customer);
        shopCart.validateSelf(UpdatingValidationGroup.class);
        return shopCardPort.update(customer, shopCart);
    }
}
