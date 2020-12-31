package com.icommerce.product.persistence.entity;


import com.icommerce.product.core.shared.LocalProfile;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.UUID;

public class AuditListener<T extends BaseEntity> {

    @PrePersist
    public void prePersist(T entity) {
        entity.setCreatedOn(LocalDateTime.now());
        entity.setId(UUID.randomUUID().toString());
        entity.setCreatedBy(LocalProfile.getUserId());
    }

    @PreUpdate
    public void preUpdate(T entity) {
        entity.setUpdatedOn(LocalDateTime.now());
        entity.setUpdatedBy(LocalProfile.getUserId());
    }
}
