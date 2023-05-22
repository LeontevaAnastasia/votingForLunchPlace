package com.votingforlunch.web.user;

import com.votingforlunch.model.Dish;
import com.votingforlunch.model.Restaurant;
import com.votingforlunch.service.DishService;
import com.votingforlunch.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/restaurants/",  produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestaurantRestController {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private final RestaurantService restaurantService;
    private final DishService dishService;

    public UserRestaurantRestController(RestaurantService restaurantService, DishService dishService) {
        this.restaurantService = restaurantService;
        this.dishService = dishService;
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("getAll restaurants");
        return restaurantService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Restaurant get(@PathVariable int id) {
        log.info("get restaurant {}", id);
        return restaurantService.get(id);
    }




}
