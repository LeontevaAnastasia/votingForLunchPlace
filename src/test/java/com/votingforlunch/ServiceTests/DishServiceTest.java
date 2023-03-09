package com.votingforlunch.ServiceTests;

import com.votingforlunch.RestaurantTestData;
import com.votingforlunch.model.Dish;
import com.votingforlunch.service.DishService;
import com.votingforlunch.util.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.votingforlunch.DishesTestData.*;
import static com.votingforlunch.RestaurantTestData.*;

@SpringBootTest
public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    DishService dishService;

    @Test
    void get() {
        Dish actual = dishService.getById(DISH_ID1, REST_ID1);
        DISH_MATCHER.assertMatch(actual, dish1);
    }

    @Test
    void getAll() {
        List<Dish> all = dishService.getAllForRestaurant(RestaurantTestData.shabby.getId());
        DISH_MATCHER.assertMatch(all, shabbyDishes);
    }

    @Test
     void create() {
        Dish created = dishService.create(getNewDish(),REST_ID1);
        System.out.println(created.toString());
        int newId = created.getId();
        Dish newDish = getNewDish();
        System.out.println(newDish);
        newDish.setId(newId);
        DISH_MATCHER.assertMatch(created, newDish);
        DISH_MATCHER.assertMatch(dishService.getById(newId,REST_ID1), newDish);
    }

    @Test
    void update() {
        Dish updated = getUpdatedDish();
        dishService.update(updated, shabby.getId());
        DISH_MATCHER.assertMatch((dishService.getById(DISH_ID1,REST_ID1)), updated);
    }

    @Test
     void delete() {
        dishService.delete(DISH_ID1,REST_ID1);
        Assertions.assertThrows(NotFoundException.class, () -> dishService.getById(DISH_ID1,REST_ID1));
    }

    @Test
    void getNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> dishService.getById(NOT_FOUND, tokyoCity.id()));
    }

    @Test
   void duplicateDishNameInRestaurantCreate() {
        Assertions.assertThrows(DataAccessException.class, () -> dishService.create(getDuplicated(), REST_ID1));
    }


}
