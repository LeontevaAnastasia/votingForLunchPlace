package com.votingforlunch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant  extends AbstractBaseEntity{
    private String restaurantName;
    private Set<Dish> dishes;
    private int voteCounter;

}
