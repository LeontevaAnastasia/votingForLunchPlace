package com.votingforlunch.ServiceTests;

import com.votingforlunch.RestaurantTestData;
import com.votingforlunch.model.Dish;
import com.votingforlunch.service.DishService;
import com.votingforlunch.util.exception.NotFoundException;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.votingforlunch.DishesTestData.*;
import static com.votingforlunch.RestaurantTestData.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DishServiceTest extends AbstractServiceTest {

    @Autowired
    DishService dishService;

    @Test(expected = LazyInitializationException.class)
    public void get() {
        Dish actual = dishService.getById(DISH_ID1, REST_ID1);
        DISH_MATCHER.assertMatch(actual, dish1);
    }

    @Test(expected = LazyInitializationException.class)
    public void getAll() {
        List<Dish> all = dishService.getAllForRestaurant(RestaurantTestData.shabby.getId());
        DISH_MATCHER.assertMatch(all, dish1, dish2);
    }

    @Test(expected = LazyInitializationException.class)
    public void create() {
        Dish created = dishService.create(getNewDish(),REST_ID1);
        System.out.println(created.toString());
        int newId = created.getId();
        Dish newDish = getNewDish();
        System.out.println(newDish.toString());
        newDish.setId(newId);
        DISH_MATCHER.assertMatch(created, newDish);
        DISH_MATCHER.assertMatch(dishService.getById(newId,REST_ID1), newDish);
    }

    @Test(expected = LazyInitializationException.class)
    public void update() {
        Dish updated = getUpdatedDish();
        dishService.update(updated, tokyoCity.getId());
        DISH_MATCHER.assertMatch((dishService.getById(DISH_ID1,REST_ID2)), updated);
    }

    @Test
    public void delete() {
        dishService.delete(DISH_ID1,REST_ID1);
        Assertions.assertThrows(NotFoundException.class, () -> dishService.getById(DISH_ID1,REST_ID1));
    }


    @Test
   public void duplicateDishNameInRestaurantCreate() {
        Assertions.assertThrows(DataAccessException.class, () -> dishService.create(getDuplicated(), REST_ID1));
    }
}
