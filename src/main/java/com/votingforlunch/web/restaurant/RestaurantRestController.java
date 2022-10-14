package com.votingforlunch.web.restaurant;

import com.votingforlunch.model.Restaurant;
import com.votingforlunch.model.User;
import com.votingforlunch.service.RestaurantService;
import com.votingforlunch.web.user.AbstractUserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RestaurantRestController{

    private final Logger log = LoggerFactory.getLogger(getClass());
    private RestaurantService restaurantService;


    public List<Restaurant> getAll() {
        log.info("getAll restaurants");
        return restaurantService.getAll();
    }


    public Restaurant get(int id) {
        log.info(("get restaurant {}"), id);
        return restaurantService.get(id);
    }


    public Restaurant create(Restaurant restaurant) {
        log.info("create restaurant {}", restaurant);
        return restaurantService.create(restaurant);
    }


    public void delete(int id) {
        log.info("delete restaurant {}", id);
        restaurantService.delete(id);
    }

    public void update(Restaurant restaurant) {
        log.info("update restaurant {}", restaurant);
        restaurantService.update(restaurant);
    }
}

