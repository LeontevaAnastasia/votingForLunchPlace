package com.votingforlunch.service;

import com.votingforlunch.model.Restaurant;
import com.votingforlunch.repository.RestaurantRepository;
import com.votingforlunch.to.RestaurantTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.votingforlunch.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "Restaurant must not be null.");
        return restaurantRepository.save(restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(restaurantRepository.getById(id), id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "Restaurant must not be null.");
        checkNotFoundWithId(restaurantRepository.save(restaurant), restaurant.getId());
    }

    public List<RestaurantTo> getAllWithVotes() {
        return restaurantRepository.getAllWithVotes();
    }
}
