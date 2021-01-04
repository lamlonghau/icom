package com.icommerce.product.core;

import com.icommerce.product.core.product.Product;
import com.icommerce.product.core.product.port.ProductPersistencePort;
import com.icommerce.product.core.product.usecase.UpdateProductUseCase;
import com.icommerce.product.core.product.usecase.impl.CreateProductUseCaseImpl;
import com.icommerce.product.core.product.usecase.impl.UpdateProductUseCaseImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class UpdateProductUseCaseTest {

    @Mock
    private ProductPersistencePort port;
    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;

    @Test
    public void testConstrainExceptionCase() {
        final Product product = new Product();
        product.setBrand("");
        product.setPrice(null);
        product.setColour("");
        product.setTitle("");
        product.setId("");
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            updateProductUseCase.execute("product_uuid", product);
        });
    }

    @Test
    public void testSuccessCase() {
        final String id = "product_uuid";
        final Product product = new Product();
        product.setBrand("nike");
        product.setPrice(BigDecimal.TEN);
        product.setColour("red");
        product.setTitle("shoes");
        product.setDescription("nike shoes");
        product.setId(id);
        Mockito.when(port.update(Mockito.anyString(), Mockito.any(Product.class))).thenReturn(product);
        Assertions.assertEquals(id, updateProductUseCase.execute("product_uuid", product).getId());
    }
}
