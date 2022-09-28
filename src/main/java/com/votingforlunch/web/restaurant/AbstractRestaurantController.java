package com.votingforlunch.web.restaurant;

import com.votingforlunch.model.Restaurant;
import com.votingforlunch.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractRestaurantController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantService restaurantService;

    public Restaurant create(Restaurant restaurant) {
        log.info("create restaurant {}", restaurant);
        return restaurantService.create(restaurant);
    }

    public Restaurant get(int id) {
        log.info(("get restaurant {}"), id);
        return restaurantService.get(id);
    }

    public List<Restaurant> getAll() {
        log.info("getAll restaurants");
        return restaurantService.getAll();
    }

    public void update(Restaurant restaurant) {
        log.info("update restaurant {}", restaurant);
        restaurantService.update(restaurant);
    }

    public void delete(int id) {
        log.info("delete restaurant {}", id);
        restaurantService.delete(id);
    }

}
