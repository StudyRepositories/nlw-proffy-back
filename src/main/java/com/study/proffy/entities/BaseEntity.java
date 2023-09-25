package com.study.proffy.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;

import java.util.UUID;

/**
 * @author caiom
 * Used to define common fields for all super classes that extend it
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    protected Long id;

    @Generated
    @Column(insertable = false, updatable = false)
    protected UUID resource;

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UUID getResource() {
        return resource;
    }

    public BaseEntity setResource(UUID resource) {
        this.resource = resource;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseEntity that = (BaseEntity) o;

        if (!id.equals(that.id)) {
            return false;
        }
        return resource.equals(that.resource);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + resource.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaseEntity{");
        sb.append("id=").append(id);
        sb.append(", resource=").append(resource);
        sb.append('}');
        return sb.toString();
    }
}
