package com.icommerce.shopcard.persistence.repository;


import com.icommerce.shopcard.persistence.entity.ShopCartEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopCartRepository extends CrudRepository<ShopCartEntity, String> {
}
