package com.icommerce.shopcard.core.shopcard.usecase.impl;

import com.icommerce.shopcard.core.shopcard.port.ShopCardPort;
import com.icommerce.shopcard.core.shopcard.usecase.DeleteShopCardUseCase;

public class DeleteShopCardUseCaseImpl implements DeleteShopCardUseCase {

    private ShopCardPort shopCardPort;

    public DeleteShopCardUseCaseImpl(ShopCardPort shopCardPort) {
        this.shopCardPort = shopCardPort;
    }

    @Override
    public void execute(String customer) {
        shopCardPort.delete(customer);
    }
}
