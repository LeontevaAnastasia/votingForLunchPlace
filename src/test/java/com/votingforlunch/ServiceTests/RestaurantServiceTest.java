package com.votingforlunch.ServiceTests;

import com.votingforlunch.RestaurantTestData;
import com.votingforlunch.model.Restaurant;
import com.votingforlunch.service.RestaurantService;
import com.votingforlunch.to.RestaurantTo;
import com.votingforlunch.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;


import java.util.List;

import static com.votingforlunch.RestaurantTestData.*;

@SpringBootTest
public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    RestaurantService restaurantService;


    @Test
    void get() {
        Restaurant actual = restaurantService.get(REST_ID1);
        RESTAURANT_MATCHER.assertMatch(actual, shabby);
    }

    @Test
    void getAll() {
        List<Restaurant> all = restaurantService.getAll();
        RESTAURANT_MATCHER.assertMatch(all, restaurants);

    }

    @Test
    void create() {
        Restaurant created = restaurantService.create(getNewRest());
        int newId = created.getId();
        Restaurant newRest = getNewRest();
        newRest.setId(newId);
        RESTAURANT_MATCHER.assertMatch(created, newRest);
        RESTAURANT_MATCHER.assertMatch(restaurantService.get(newId), newRest);
    }

    @Test
    void update() {
        Restaurant updated = getUpdatedRest();
        restaurantService.update(updated);
        RESTAURANT_MATCHER.assertMatch(restaurantService.get(REST_ID1), updated);
    }


    @Test
    void delete() {
        restaurantService.delete(REST_ID1);
        Assertions.assertThrows(NotFoundException.class, () -> restaurantService.get(REST_ID1));
    }

    @Test
    void createDuplicate() {
        Assertions.assertThrows(DataAccessException.class, () -> restaurantService.create(getNewDuplicate()));
    }

    @Test
    void getNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> restaurantService.get(RestaurantTestData.NOT_FOUND));
    }

    @Test
    void getAllWithVotes() {
        List<RestaurantTo> all = restaurantService.getAllWithVotes();
        RESTAURANT_TO_MATCHER.assertMatch(all, getWithVotes());

    }


}
