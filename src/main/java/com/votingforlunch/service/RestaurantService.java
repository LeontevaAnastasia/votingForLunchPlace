package com.votingforlunch.service;

import com.votingforlunch.model.Restaurant;
import com.votingforlunch.model.User;
import com.votingforlunch.repository.RestaurantRepository;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

public class RestaurantService {
    RestaurantRepository restaurantRepository;

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(restaurantRepository.getReferenceById(id), id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public void update(Restaurant restaurant) {
        checkNotFoundWithId(restaurantRepository.save(restaurant), restaurant.getId());
    }
}
