package com.votingforlunch.repository;

import com.votingforlunch.model.Dish;
import java.util.List;

public interface DishRepository {
    Dish save( Dish  restaurant);


    boolean delete(int id);


    Dish get(int id);


    List<Dish> getAll();
}
