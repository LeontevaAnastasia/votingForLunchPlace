package com.votingforlunch.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "restaurants")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant  extends AbstractBaseEntity{

    @Column(name = "restaurant_name")
    @Size(max = 128)
    @NotBlank
    private String restaurantName;

    @Column(name = "address")
    @Size(max = 128)
    @NotBlank
    private String address;

    @Enumerated(EnumType.STRING)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<Dish> dishes;


}
