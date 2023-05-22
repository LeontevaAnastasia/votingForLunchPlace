package com.votingforlunch.to;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.votingforlunch.HasId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractBaseTo implements HasId {

    @JsonIgnore
    protected Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
