package com.votingforlunch.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class RestaurantTo extends AbstractBaseTo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    Long votesCount;

    public RestaurantTo(Integer id, Long votesCount) {
        super(id);
        this.votesCount = votesCount;
    }

}
