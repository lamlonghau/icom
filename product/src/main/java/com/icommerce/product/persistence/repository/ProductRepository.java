package com.icommerce.product.persistence.repository;

import com.icommerce.product.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String>,
        JpaSpecificationExecutor<ProductEntity> {

}