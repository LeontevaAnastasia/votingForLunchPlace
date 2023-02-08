package com.votingforlunch.ServiceTests;

import com.votingforlunch.RestaurantTestData;
import com.votingforlunch.model.Restaurant;
import com.votingforlunch.service.RestaurantService;
import com.votingforlunch.to.RestaurantTo;
import com.votingforlunch.util.exception.NotFoundException;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.votingforlunch.RestaurantTestData.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestaurantServiceTest extends AbstractServiceTest {

    @Autowired
    RestaurantService restaurantService;


    @Test(expected = LazyInitializationException.class)
    public void get() {
        Restaurant actual = restaurantService.get(REST_ID1);
        RESTAURANT_MATCHER.assertMatch(actual, shabby);
    }

    @Test
    public void getAll() {
        List<Restaurant> all = restaurantService.getAll();
        RESTAURANT_MATCHER.assertMatch(all, restaurants);

    }

    @Test(expected = LazyInitializationException.class)
    public void create() {
        Restaurant created = restaurantService.create(getNewRest());
        int newId = created.getId();
        Restaurant newRest = getNewRest();
        newRest.setId(newId);
        RESTAURANT_MATCHER.assertMatch(created, newRest);
        RESTAURANT_MATCHER.assertMatch(restaurantService.get(newId), newRest);
    }

    @Test(expected = LazyInitializationException.class)
    public void update() {
        Restaurant updated = getUpdatedRest();
        restaurantService.update(updated);
        RESTAURANT_MATCHER.assertMatch(restaurantService.get(REST_ID1), updated);
    }


    @Test(expected = LazyInitializationException.class)
    public void delete() {
        restaurantService.delete(REST_ID1);
        Assert.assertNull(restaurantService.get(REST_ID1));
    }

    @Test
    public void createDuplicate() {
        Assertions.assertThrows(DataAccessException.class, () -> restaurantService.create(getNewDuplicate()));
    }

    @Test
    public void getNotFound() {
        Assertions.assertThrows(NotFoundException.class, () -> restaurantService.get(RestaurantTestData.NOT_FOUND));
    }

    @Test
    public void getAllWithVotes() {
        List<RestaurantTo> all = restaurantService.getAllWithVotes();
        RESTAURANT_TO_MATCHER.assertMatch(all, getWithVotes());

    }
}
