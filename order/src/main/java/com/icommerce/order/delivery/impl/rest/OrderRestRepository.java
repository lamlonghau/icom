package com.icommerce.order.delivery.impl.rest;

import com.icommerce.order.persistence.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRestRepository extends MongoRepository<OrderEntity, String> {
}
