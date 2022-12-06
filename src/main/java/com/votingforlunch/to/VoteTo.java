package com.votingforlunch.to;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VoteTo extends AbstractBaseTo {

    private static final long serialVersionUID = 1L;

    @NotNull
    private int restaurantId;


}
