package com.icommerce.product.core;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.port.ProductPersistencePort;
import com.icommerce.product.core.product.usecase.impl.FindProductsUseCaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindProductsUseCaseTest {

    @Mock
    private ProductPersistencePort port;
    @InjectMocks
    private FindProductsUseCaseImpl findProductsUseCase;

    @Test
    public void testNoResultCase() {
        Mockito.when(port.find(Mockito.anyString(), Mockito.anyString(),
                Mockito.anyInt(), Mockito.anyInt())).thenReturn(Collections.emptyList());
        Assertions.assertEquals(0, findProductsUseCase.execute("colour:*", "id+", 10, 0).size());
    }

    @Test
    public void testHasResultCase() {
        final Product product = new Product();
        product.setId("product_uuid");
        product.setBrand("nike");
        product.setPrice(BigDecimal.TEN);
        product.setColour("red");
        product.setTitle("shoes");
        product.setDescription("nike shoes");
        Mockito.when(port.find(Mockito.anyString(), Mockito.anyString(),
                Mockito.anyInt(), Mockito.anyInt())).thenReturn(Collections.singletonList(product));
        final List<Product> products = findProductsUseCase.execute("colour:*", "id+", 10, 0);
        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals("product_uuid", products.get(0).getId());
    }
}
