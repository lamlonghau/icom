package com.icommerce.product.persistence.shared;

import com.icommerce.product.core.shared.CommonUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SpecificationBuilder {
    
    public static <T> Specification<T> build(List<Specification<T>> specs) {
        Specification<T> spec = null;
        if (!CommonUtils.isNullOrEmpty(specs)) {
            spec = specs.get(0);
            for (int i = 1; i < specs.size(); i++) {
                spec = Specification.where(spec).and(specs.get(i));
            }
        }
        return spec;
    }

    public static <T> Specification<T> buildOr(List<Specification<T>> specs) {
        Specification<T> spec = null;
        if (!CommonUtils.isNullOrEmpty(specs)) {
            spec = specs.get(0);
            for (int i = 1; i < specs.size(); i++) {
                spec = Specification.where(spec).or(specs.get(i));
            }
        }
        return spec;
    }
}
