package com.votingforlunch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Proxy(lazy = false)
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_name", "address"}, name = "restaurant_unique_name_address_idx")})
public class Restaurant  extends AbstractBaseEntity {

    @Column(name = "restaurant_name")
    @Size(max = 128)
    @NotBlank
    private String restaurantName;

    @Column(name = "address")
    @Size(max = 128)
    @NotBlank
    private String address;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private Set<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(Restaurant r) {
        this(r.getId(), r.restaurantName, r.address);
    }

    public Restaurant(Integer id, String restaurantName, String address) {
        super(id);
        this.restaurantName = restaurantName;
        this.address = address;
    }



}