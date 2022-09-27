package com.votingforlunch.repository;

import com.votingforlunch.model.Dish;
import com.votingforlunch.model.Restaurant;

import java.util.Collection;

public interface DishRepository {
    Dish save( Dish  restaurant);


    boolean delete(int id);


    Dish get(int id);


    Collection<Dish> getAllDishes();
}
