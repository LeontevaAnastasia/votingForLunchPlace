package com.votingforlunch.web.user;

import com.votingforlunch.model.Dish;
import com.votingforlunch.service.DishService;
import com.votingforlunch.web.admin.DishRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/restaurants/{restaurantId}/dishes", produces = MediaType.APPLICATION_JSON_VALUE)

public class UserDishRestController {

    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    private final DishService dishService;


    public UserDishRestController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping()
    public List<Dish> getAllDishForRestaurant(@PathVariable int restaurantId) {
        log.info("getAll dishes");
        return dishService.getAllForRestaurant(restaurantId);
    }

    @GetMapping(value = "/{id}")
    public Dish get(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("get dish {}", id);
        return dishService.getById(id,restaurantId);
    }
}
