package com.icommerce.shopcard.core.usecase.impl;

import com.icommerce.shopcard.core.port.ShopCardPort;
import com.icommerce.shopcard.core.usecase.DeleteShopCardUseCase;

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
