package io.warlock.spring.security.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Column(name = "is_active", columnDefinition = "tinyint(1) default 1")
    private Boolean active;

    @Column(name = "is_deleted", columnDefinition = "tinyint(1) default 0")
    private Boolean deleted;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdDate;

    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @UpdateTimestamp
    @Column(name = "last_updated_at", insertable = false)
    private Timestamp lastUpdate;

    @Column(name = "modified_by", insertable = false)
    private Long lastUpdateBy;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }
}
