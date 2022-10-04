package com.votingforlunch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AbstractNamedEntity extends AbstractBaseEntity{
    protected String name;

    protected AbstractNamedEntity(Integer id, String name) {
       super(id);
       this.name = name;
    }
    public AbstractNamedEntity(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
}
