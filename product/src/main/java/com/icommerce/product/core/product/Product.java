package com.icommerce.product.core.product;

import com.icommerce.product.core.shared.CreationValidationGroup;
import com.icommerce.product.core.shared.SelfValidating;
import com.icommerce.product.core.shared.UpdatingValidationGroup;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class Product extends SelfValidating<Product> {

    @NotEmpty(groups = {UpdatingValidationGroup.class})
    private String id;
    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private String title;
    private String description;
    private String brand;
    @NotNull(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private BigDecimal price;
    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private String colour;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
