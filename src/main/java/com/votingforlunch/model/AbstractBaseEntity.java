package com.votingforlunch.model;

import com.votingforlunch.HasId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.util.Assert;

import javax.persistence.*;

@MappedSuperclass
@AllArgsConstructor
@Getter
@Setter
@Access(AccessType.FIELD)
public abstract class AbstractBaseEntity implements HasId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected Integer id;

    public int id() {
        Assert.notNull(id, "Entity must have id");
        return id;
    }

    @Schema(hidden = true)
    @Override
    public boolean isNew() {
        return this.id == null;
    }

    public AbstractBaseEntity(){

    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        AbstractBaseEntity that = (AbstractBaseEntity) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id;
    }
}

