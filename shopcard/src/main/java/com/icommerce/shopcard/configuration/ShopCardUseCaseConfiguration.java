package com.icommerce.shopcard.configuration;

import com.icommerce.shopcard.core.port.ShopCardPort;
import com.icommerce.shopcard.core.usecase.*;
import com.icommerce.shopcard.core.usecase.impl.*;
import com.icommerce.shopcard.persistence.impl.ShopCardPortImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopCardUseCaseConfiguration {

    @Bean
    public ShopCardPort shopCardPort() {
        return new ShopCardPortImpl();
    }

    @Bean
    public DeleteShopCardUseCase deleteShopCardUseCase(ShopCardPort shopCardPort) {
        return new DeleteShopCardUseCaseImpl(shopCardPort);
    }

    @Bean
    public UpdateShopCardUseCase updateShopCardUseCase(ShopCardPort shopCardPort) {
        return new UpdateShopCardUseCaseImpl(shopCardPort);
    }

    @Bean
    public FindAllShopCardsUseCase findAllShopCardsUseCase(ShopCardPort shopCardPort) {
        return new FindAllShopCardsUseCaseImpl(shopCardPort);
    }

    @Bean
    public FindShopCardsByCustomerUseCase findShopCardsByCustomerUseCase(ShopCardPort shopCardPort) {
        return new FindShopCardsByCustomerUseCaseImpl(shopCardPort);
    }

    @Bean
    public CreateShopCardUseCase createShopCardUseCase(ShopCardPort shopCardPort) {
        return new CreateShopCardUseCaseImpl(shopCardPort);
    }
}
