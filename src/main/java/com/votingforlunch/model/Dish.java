package com.votingforlunch.model;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@AllArgsConstructor
public class Dish extends AbstractBaseEntity {

    @Column(name = "dish_name", nullable = false)
    @Size(min = 1, max = 100)
    @NotBlank
    private String dishName;

    @Column(name = "created", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    private LocalDate date;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 1, max = 100000)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rest_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Restaurant restaurant;

    public Dish(){
    }

    public Dish(Integer id, String dishName, LocalDate date, Double price, Restaurant restaurant){
        super(id);
        this.dishName=dishName;
        this.date=date;
        this.price=price;
        this.restaurant=restaurant;
    }

    public Dish(Dish d){
        this(d.getId(),d.dishName,d.date,d.price,d.restaurant);

    }

}
