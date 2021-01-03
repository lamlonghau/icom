package com.icommerce.shopcard.core.shopcard;

import com.icommerce.shopcard.core.shared.CreationValidationGroup;
import com.icommerce.shopcard.core.shared.UpdatingValidationGroup;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class Product {

    private String id;
    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private String name;
    private String category;
    @NotEmpty(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private List<String> attributes;
    @NotNull(groups = {CreationValidationGroup.class, UpdatingValidationGroup.class})
    private BigDecimal price;

    public Product() {
    }

    public Product(String id, String name, String category,
                   List<String> attributes, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.attributes = attributes;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
