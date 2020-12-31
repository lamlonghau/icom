package com.icommerce.product.persistence.entity;

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = AuditListener.class)
public abstract class BaseEntity implements Serializable, Persistable<String> {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    protected String id;

    @Version
    protected Long version;

    @Column(name = "created_on", nullable = false)
    protected LocalDateTime createdOn;

    @Column(name = "created_by", nullable = false)
    protected String createdBy;

    @Column(name = "updated_on")
    protected LocalDateTime updatedOn;

    @Column(name = "updated_by")
    protected String updatedBy;

    @Transient
    protected boolean isUpdated;

    @Override
    public boolean isNew() {
        return !isUpdated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isUpdated() {
        return isUpdated;
    }

    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }
}
