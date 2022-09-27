package com.votingforlunch.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String dishName;
    private LocalDate date;
    private double price;
}
