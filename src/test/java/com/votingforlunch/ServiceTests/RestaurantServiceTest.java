package com.votingforlunch.ServiceTests;

import com.votingforlunch.model.Restaurant;
import com.votingforlunch.service.RestaurantService;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.votingforlunch.RestaurantTestData.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestaurantServiceTest extends AbstractServiceTest{

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

}
