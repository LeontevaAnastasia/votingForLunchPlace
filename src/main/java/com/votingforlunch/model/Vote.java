package com.votingforlunch.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "votes", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "created"}, name = "vote_unique_user_created_idx")})
public class Vote extends AbstractBaseEntity{
    @Column(name = "created", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_DATE")
    @NotNull
    private LocalDate date;

    @Column(name = "user_id", nullable = false)
    @NotNull
    private int userId;

    @Column(name = "rest_id", nullable = false)
    @NotNull
    private int restaurantId;

    public Vote(){

    }

    public Vote (Integer id, LocalDate date, Integer userId, Integer restaurantId) {
        super(id);
        this.date=date;
        this.userId=userId;
        this.restaurantId = restaurantId;
    }



}
