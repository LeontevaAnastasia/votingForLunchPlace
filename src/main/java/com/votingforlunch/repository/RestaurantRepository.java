package com.votingforlunch.repository;

import com.votingforlunch.model.Restaurant;

import java.util.Collection;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);


    boolean delete(int id);


    Restaurant get(int id);


    Collection<Restaurant> getAllRestaurant();
}
