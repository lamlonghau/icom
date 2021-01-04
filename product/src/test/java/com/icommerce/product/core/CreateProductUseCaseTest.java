package com.icommerce.product.core;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.port.ProductPersistencePort;
import com.icommerce.product.core.product.usecase.impl.CreateProductUseCaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class CreateProductUseCaseTest {

    @Mock
    private ProductPersistencePort port;
    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @Test
    public void testConstrainExceptionCase() {
        final Product product = new Product();
        product.setBrand("");
        product.setPrice(null);
        product.setColour("");
        product.setTitle("");
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            createProductUseCase.execute(product);
        });
    }

    @Test
    public void testSuccessCase() {
        final Product product = new Product();
        product.setBrand("nike");
        product.setPrice(BigDecimal.TEN);
        product.setColour("red");
        product.setTitle("shoes");
        product.setDescription("nike shoes");
        final String id = "product_uuid";
        Mockito.when(port.create(Mockito.any(Product.class))).thenReturn(id);
        Assertions.assertEquals(id, createProductUseCase.execute(product));
    }
}
