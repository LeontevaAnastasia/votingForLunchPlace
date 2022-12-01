package com.votingforlunch.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@ToString

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Restaurant that = (Restaurant) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
